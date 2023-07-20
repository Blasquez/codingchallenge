package com.gila.codingchallenge.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.gila.codingchallenge.database.CategoryRepository;
import com.gila.codingchallenge.database.UserRepository;
import com.gila.codingchallenge.model.Category;
import com.gila.codingchallenge.model.NotificationRequest;
import com.gila.codingchallenge.model.User;
import com.gila.codingchallenge.notifier.ChannelNotifier;
import com.gila.codingchallenge.notifier.EmailNotifier;
import com.gila.codingchallenge.notifier.PushNotifier;
import com.gila.codingchallenge.notifier.SmsNotifier;
import com.gila.codingchallenge.service.NotificationService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

	private final CategoryRepository categoryRepository;
	
	private final UserRepository userRepository;
	
	@Autowired
	private SmsNotifier smsNotifier;
	
	@Autowired
	private EmailNotifier emailNotifier;
	
	@Autowired
	private PushNotifier pushNotifier;
	
	@Value("${user.page.size:1}")
	private Integer userPageSize;
	
	@Override
	public void create(NotificationRequest notification) {
		String categoryName = notification.getCategoryName();
		
		Category category = categoryRepository.findByName(categoryName)
				                              .orElseThrow(() -> new IllegalArgumentException("There is no category name " + categoryName));
		
		Pageable userPagination = PageRequest.of(0, userPageSize);
		sendNotifications(userPagination, category, notification.getMessage());
	
	}
	
	private void sendNotifications(Pageable usersPageable, Category category, String message) {
		Page<User> users = userRepository.findAllBySubscribed(usersPageable, category);
		if(users.getNumberOfElements() > 0) {
			notifyUsers(users.getContent(), message, category.getName());
			if(users.getTotalPages() > 1 && !users.isLast()) {
				usersPageable = PageRequest.of(users.getNumber() + 1, userPageSize);
				sendNotifications(usersPageable, category, message);
			}
		}
		
	}
	
	private void notifyUsers(List<User> users, String message, String categoryName){
		
		List<User> smsUsers = new ArrayList<>();
		
		List<User> emailUsers = new ArrayList<>();
		
		List<User> pushUsers = new ArrayList<>();
		
		users.forEach(user -> {
			user.getChannels().forEach(channel -> {
				if("SMS".equalsIgnoreCase(channel.getName())) {
					smsUsers.add(user);
				}
				
				if("E-mail".equalsIgnoreCase(channel.getName())) {
					emailUsers.add(user);
				}
				
				if("Push Notificacion".equalsIgnoreCase(channel.getName())) {
					pushUsers.add(user);
				}
			});
		});
		
		if(!smsUsers.isEmpty()) {
			ChannelNotifier channelNotifier = new ChannelNotifier(smsNotifier, smsUsers, message, categoryName);
			channelNotifier.start();
		}
		
		if(!emailUsers.isEmpty()) {
			ChannelNotifier channelNotifier = new ChannelNotifier(emailNotifier, emailUsers, message, categoryName);
			channelNotifier.start();
		}
		
		if(!pushUsers.isEmpty()) {
			ChannelNotifier smsChannelNotifier = new ChannelNotifier(pushNotifier, pushUsers, message, categoryName);
			smsChannelNotifier.start();
		}
		
	}
	
	
}

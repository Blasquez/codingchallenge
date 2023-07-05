package com.gila.codingchallenge.service.impl;

import static java.lang.String.format;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.gila.codingchallenge.database.CategoryRepository;
import com.gila.codingchallenge.database.UserRepository;
import com.gila.codingchallenge.model.Category;
import com.gila.codingchallenge.model.Notification;
import com.gila.codingchallenge.model.User;
import com.gila.codingchallenge.service.NotificationService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

	private final CategoryRepository categoryRepository;
	
	private final UserRepository userRepository;
	
	@Value("${user.page.size:1}")
	private Integer userPageSize;
	
	@Override
	public void create(Notification notification) {
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
	
	private void notifyUsers(List<User> users, String message, String categoryName) {
		
		Notifier notifier = new Notifier(users, message, categoryName);
		notifier.start();
		
	}
	
	@AllArgsConstructor
	class Notifier extends Thread{
	
		List<User> users;		
		String message;
		String category;
		
		@Override
		public void run() {
			String logMessage = "\nDate: %s \n" +
		            "Name: %s \n" + 
					"Category: %s \n" +
                    "Channel: %s \n" +
					"Message: %s";
			users.forEach(user -> {
				user.getChannels().forEach(channel -> log.info(format(logMessage, LocalDateTime.now(), user.getName(), category, channel.getName(), message)));
			});
		}
		
		
		
	}

}

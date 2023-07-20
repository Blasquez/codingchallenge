package com.gila.codingchallenge.notifier;

import static java.lang.String.format;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.gila.codingchallenge.database.NotificationRepository;
import com.gila.codingchallenge.factory.NotificationFactory;
import com.gila.codingchallenge.model.Notification;
import com.gila.codingchallenge.model.User;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PushNotifier implements Notifier{
	
	private final NotificationRepository notificationRepository;
	
	private final String CHANNEL_NAME = "Push Notificacion";
	
	private LocalDateTime lastNotificationAt;
	
	@Value("${notifier.wait.time.seconds:5}")
	private Integer notifierWaitTime;	

	@Override
	public synchronized void send(List<User> users, String message, String categoryName) throws InterruptedException {
		if(lastNotificationAt != null && lastNotificationAt.plusSeconds(notifierWaitTime).isAfter(LocalDateTime.now())) {
			Thread.sleep(notifierWaitTime * 1000);
		}
		
		users.forEach(user -> {
			Notification notification = NotificationFactory.createNotification(user, message, categoryName, CHANNEL_NAME);
		   	if(notification != null) {
		   		notificationRepository.save(notification);
		   		String logMessage = "\nDate: %s \n" +
			            "Name: %s \n" + 
			            "E-mail: %s \n" + 
						"Category: %s \n" +
	                    "Channel: %s \n" +
						"Message: %s";
		   		
		   		System.out.println(format(logMessage, notification.getDateTime(), notification.getUserName(), notification.getUserEmail(), notification.getCategory(), notification.getChannel(), notification.getMessage()));
		   		lastNotificationAt = LocalDateTime.now();
		   	}
		});
	}

}

package com.gila.codingchallenge.factory;

import com.gila.codingchallenge.model.EmailNotification;
import com.gila.codingchallenge.model.Notification;
import com.gila.codingchallenge.model.PushNotification;
import com.gila.codingchallenge.model.SmsNotification;
import com.gila.codingchallenge.model.User;

public class NotificationFactory {

	public static Notification createNotification(User user, String message, String category, String channel) {
		Notification notification = null;
		
		if("SMS".equalsIgnoreCase(channel)) {
			notification = (Notification)SmsNotification.builder().userName(user.getName())
					                                .userEmail(user.getEmail())
					                                .userPhone(user.getPhone())
					                                .message(message)
					                                .category(category)
					                                .build();
		}
		
		if("E-mail".equalsIgnoreCase(channel)) {
			notification = (Notification) EmailNotification.builder().userName(user.getName())
					                                .userEmail(user.getEmail())
					                                .userPhone(user.getPhone())
					                                .message(message)
					                                .category(category)
					                                .build();
		}
		
		if("Push Notificacion".equalsIgnoreCase(channel)) {
			notification = (Notification) PushNotification.builder().userName(user.getName())
					                                .userEmail(user.getEmail())
					                                .userPhone(user.getPhone())
					                                .message(message)
					                                .category(category)
					                                .build();
		}
		
		return notification;
	}
}

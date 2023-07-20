package com.gila.codingchallenge.model;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PushNotification extends Notification {

	@Builder
	public PushNotification(String userName, String userEmail, String userPhone, String message, String category) {
		super(userName, userEmail, userPhone, message, category);
		this.channel = "Push Notificacion";
	}

}

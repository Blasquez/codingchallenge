package com.gila.codingchallenge.model;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SmsNotification extends Notification {

	@Builder
	public SmsNotification(String userName, String userEmail, String userPhone, String message, String category) {
		super(userName, userEmail, userPhone, message, category);
		this.channel = "SMS";
	}

	
	
	

}

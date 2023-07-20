package com.gila.codingchallenge.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "notifications")
public class Notification{

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Getter
	@Setter
	private Long id;
	
	@Getter
	@Setter
	private String userName;
	
	@Getter
	@Setter
	private String userEmail;
	
	@Getter
	@Setter
	private String userPhone;
	
	@Getter
	@Setter
	private String message;
	
	@Getter
	@Setter
	private String category;
	
	@Getter
	protected String channel;
	
	@Getter
	private LocalDateTime dateTime = LocalDateTime.now();	
	
	public Notification(String userName, String userEmail, String userPhone, String message, String category) {
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.message = message;
		this.category = category;
	}
	
}

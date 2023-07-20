package com.gila.codingchallenge.notifier;

import java.util.List;

import com.gila.codingchallenge.model.User;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ChannelNotifier extends Thread{

	private Notifier notifier;
	
	private List<User> users;
	
	private String message;
	
	private String categoryName;
	
	public ChannelNotifier(Notifier notifier, List<User> users, String message, String categoryName) {
		this.notifier = notifier;
		this.users = users;
		this.message = message;
		this.categoryName = categoryName;
	}
	
	@Override
	public void run() {
		try {
			notifier.send(this.users, this.message, this.categoryName);
		} catch (InterruptedException e) {
			log.error("Notifier Error: " + e.getMessage());
		}
	}
}

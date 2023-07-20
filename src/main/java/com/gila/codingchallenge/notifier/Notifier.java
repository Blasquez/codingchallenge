package com.gila.codingchallenge.notifier;

import java.util.List;

import com.gila.codingchallenge.model.User;

public interface Notifier {

	void send(List<User> users, String message, String categoryName) throws InterruptedException;
}

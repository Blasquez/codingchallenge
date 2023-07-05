package com.gila.codingchallenge.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;;

public class NotFoundException extends BackendCodingChallengeException{
	
	public NotFoundException(String message) {
		super(message, NOT_FOUND);
	}

}

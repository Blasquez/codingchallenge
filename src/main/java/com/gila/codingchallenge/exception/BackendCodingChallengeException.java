package com.gila.codingchallenge.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BackendCodingChallengeException extends RuntimeException{

	private final String message;
	
	private final HttpStatus status;
}

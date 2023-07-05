package com.gila.codingchallenge.exception.handler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gila.codingchallenge.exception.BackendCodingChallengeException;
import com.gila.codingchallenge.exception.NotFoundException;
import com.gila.codingchallenge.model.ErrorResponse;

@RestControllerAdvice
public class BackendCodingChallengeExceptionHandler {

	@ResponseBody
	@ResponseStatus(BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	public ErrorResponse handleMethodArgumentNotValidException(final IllegalArgumentException exception) {
		Set<String> validations = new HashSet<>();
		validations.add(exception.getMessage());
		return ErrorResponse.builder().validations(validations)
				                      .message("Invalid argument.")
									  .title(BAD_REQUEST.name())
				                      .statusCode(BAD_REQUEST.value())
				                      .build();
	}
	
	@ResponseBody
	@ResponseStatus(NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public ErrorResponse handleDeviceNotFoundException(final BackendCodingChallengeException exception) {
		return ErrorResponse.builder().message(exception.getMessage())
				                      .title(exception.getStatus().name())
				                      .statusCode(exception.getStatus().value())
				                      .build();
	}
}

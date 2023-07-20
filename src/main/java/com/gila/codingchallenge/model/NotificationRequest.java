package com.gila.codingchallenge.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationRequest {

	@NotBlank(message = "categoryName is required.")
	private String categoryName;
	
	@NotBlank(message = "message is required.")
	@Size(message = "Message should have 500 characters maximum.")
	private String message;
}

package com.gila.codingchallenge.controller;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.gila.codingchallenge.model.NotificationRequest;
import com.gila.codingchallenge.service.NotificationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
@Tag(name = "notification", description = "Notification Management")
@SecurityRequirement(name = "basicAuth")
public class NotificationController {

	private final NotificationService service;
	
	@Operation(summary = "Create a new notification", tags = "notification")
	@ApiResponses(value = {@ApiResponse(responseCode = "202", description = "Accepted"),
	                       @ApiResponse(responseCode = "401", description = "Unauthorized", content = {@Content(schema = @Schema(implementation = ResponseStatusException.class))}),
	                       @ApiResponse(responseCode = "400", description = "Bad Request", content = {@Content(schema = @Schema(implementation = ResponseStatusException.class))}),
	                       @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(schema = @Schema(implementation = ResponseStatusException.class))})})
	@PostMapping(consumes = APPLICATION_JSON_VALUE)
	@ResponseStatus(ACCEPTED)
	public ResponseEntity<Void> postNotification(@Valid @RequestBody final NotificationRequest notification) {
		service.create(notification);
		return ResponseEntity.accepted().build();
	}
}

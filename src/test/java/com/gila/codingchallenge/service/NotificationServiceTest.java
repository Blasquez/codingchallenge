package com.gila.codingchallenge.service;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gila.codingchallenge.database.CategoryRepository;
import com.gila.codingchallenge.model.Notification;
import com.gila.codingchallenge.service.impl.NotificationServiceImpl;


@ExtendWith(MockitoExtension.class)
public class NotificationServiceTest {

	@Mock
	private CategoryRepository categoryRepository;
	
	@InjectMocks
	private NotificationServiceImpl service;
	
	@Test
	void whenPostNotificationWithInValidCategoryThenThrowBadRequest() {
		when(categoryRepository.findByName(anyString())).thenReturn(Optional.empty());
		
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.create(Notification.builder()
					                        .categoryName("xpto")
					                        .message("lorem ipsum")
					                        .build());
		});
		
		Assertions.assertEquals("There is no category name xpto", exception.getMessage());
	}
	
}

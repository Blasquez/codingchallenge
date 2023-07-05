package com.gila.codingchallenge.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.gila.codingchallenge.CodingChallengeApplication;

@SpringBootTest(
		  webEnvironment = SpringBootTest.WebEnvironment.MOCK,
		  classes = CodingChallengeApplication.class)
@AutoConfigureMockMvc
public class NotificationControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void postNotification() throws Exception {
		mockMvc.perform(post("/notifications")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Basic dGVzdDp0ZXN0")
                .content("{\"categoryName\":\"Sports\",\"message\": \"lorem ipsum dolar\"}"))
        .andExpect(status().isAccepted());
		
	}
	
	@Test
	void whenPostNotificationWithoutCategoryNameThenBadRequest() throws Exception {
		mockMvc.perform(post("/notifications")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Basic dGVzdDp0ZXN0")
                .content("{\"message\": \"lorem ipsum dolar\"}"))
        .andExpect(status().isBadRequest());
		
	}
	
	@Test
	void whenPostNotificationWithoutMessageThenBadRequest() throws Exception {
		mockMvc.perform(post("/notifications")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Basic dGVzdDp0ZXN0")
                .content("{\"categoryName\":\"Sports\"}"))
        .andExpect(status().isBadRequest());
		
	}
}

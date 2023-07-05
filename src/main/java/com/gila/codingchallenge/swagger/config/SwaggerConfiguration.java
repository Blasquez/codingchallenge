package com.gila.codingchallenge.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

	@Bean
    public OpenAPI swaggerDocOpenApi() {
        return new OpenAPI()
        				.info(new Info().title("Notification API")
                        .description("Notification API sends notification for user by channels based upon their categories subscription.")
                        .version("v0.0.1"));
    }
}

package com.grognak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@Configuration
@ComponentScan
public class CrowdnoiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueueController.class, args);
	}

	@Bean
	public YoutubeQueue youtubeQueue() {
		return new YoutubeQueue();
	}
}

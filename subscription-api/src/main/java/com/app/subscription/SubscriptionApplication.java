package com.app.subscription;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SubscriptionApplication {
	public static void main(String[] args) {
		SpringApplication.run(SubscriptionApplication.class, args);
	}
}

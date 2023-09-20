package com.server.cloud.main.controller;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class MainConfig {
	 
	public String generateVerificationCode() {
	        Random random = new Random();
	        int code = 100000 + random.nextInt(900000);

	        return String.valueOf(code);
	    }
	
	
}

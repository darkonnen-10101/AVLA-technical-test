package com.darkonnen.test.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darkonnen.test.util.AuthBean;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	
	
	@GetMapping("/basicauth")
	public AuthBean chechAuth() {
		return new AuthBean("Authenticated");
	}

}

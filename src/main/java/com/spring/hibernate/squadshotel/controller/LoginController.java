package com.spring.hibernate.squadshotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	@GetMapping("/login")
	public String login() {
		logger.info("login");
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		logger.info("Home Page");
		return "index";
	}
}

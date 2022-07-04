package com.spring.hibernate.squadshotel.controller;

import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.hibernate.squadshotel.service.UserServiceImpl;

@Controller
public class MainController {
	@Autowired
	UserServiceImpl userServiceImpl;

	Logger logger = LoggerFactory.getLogger(MainController.class);

	@RequestMapping(value = "/Squads")
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/About")
	public ModelAndView about() {
		return new ModelAndView("about");
	}

	@RequestMapping(value = "/Contact")
	public ModelAndView contact() {
		return new ModelAndView("contact");
	}
	
}

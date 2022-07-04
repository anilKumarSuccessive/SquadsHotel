package com.spring.hibernate.squadshotel.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.hibernate.squadshotel.controller.dto.UserRegistrationDto;
import com.spring.hibernate.squadshotel.model.User;


public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}

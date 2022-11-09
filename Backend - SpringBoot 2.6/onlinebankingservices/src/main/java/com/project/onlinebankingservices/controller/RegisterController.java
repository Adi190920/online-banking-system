package com.project.onlinebankingservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.model.Authorities;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.respository.Authoritiesdtls;
import com.project.onlinebankingservices.service.AuthoritiesdtlsService;
import com.project.onlinebankingservices.service.UserdtlsService;

@RestController
public class RegisterController {

	@Autowired
	private AuthoritiesdtlsService aservice;
	
	@Autowired
	private UserdtlsService uservice;
	
	@PostMapping("/register")
	public String register(@RequestBody User user) {
		
		
		 if (uservice.findUser(user.getAccountnumber()).isPresent())
		 {
			 return "User already exists";
		 }
		
		PasswordEncoder pe = new BCryptPasswordEncoder();
		user.setPassword(pe.encode(user.getPassword()));
		
		Authorities auth = new Authorities();
		auth.setAuthority("user");
		auth.setUsername(user.getUsername());
		
		// Also check is present eith Auth Tables
		aservice.registerAuth(auth);
		uservice.registerUser(user);
		return "Sucess";
		
	}
	

}

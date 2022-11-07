package com.project.onlinebankingservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.model.Authorities;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.service.AuthoritiesdtlsService;
import com.project.onlinebankingservices.service.UserdtlsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class RegisterController {

	@Autowired
	private AuthoritiesdtlsService aservice;
	
	@Autowired
	private UserdtlsService uservice;
	
	@PostMapping("/register")
	public String register(@RequestBody User user) {
		
		
		 if (uservice.findUser(user.getAccountnumber()).isPresent())
		 {
			 return "user already exits";
		 }
		

		user.setPassword(user.getPassword());
		
		Authorities auth = new Authorities();
		auth.setAuthority("user");
		auth.setUsername(user.getUsername());
		

		aservice.registerAuth(auth);
		uservice.registerUser(user);
		return "Sucess";
		
	}
	

}

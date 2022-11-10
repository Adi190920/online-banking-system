package com.project.onlinebankingservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.exceptions.AlreadyFoundException;
import com.project.onlinebankingservices.exceptions.NotFoundException;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.service.RegisterService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class RegisterController {

	@Autowired
	private RegisterService rService;

	@PostMapping("/register")
	public ResponseEntity<User> Register(@RequestBody User user) throws NotFoundException, AlreadyFoundException {
		return rService.doRegister(user);
	}
}

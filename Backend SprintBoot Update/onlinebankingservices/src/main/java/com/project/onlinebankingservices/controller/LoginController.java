package com.project.onlinebankingservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.exceptions.NotFoundException;
import com.project.onlinebankingservices.model.Logindata;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.service.LoginService;

@CrossOrigin
@RestController
public class LoginController {

	@Autowired
	private LoginService lservice;

	@PostMapping("/login")
	public ResponseEntity<User> loginApi(@RequestBody Logindata data) throws NotFoundException {

		return lservice.getloggedin(data);

	}

}

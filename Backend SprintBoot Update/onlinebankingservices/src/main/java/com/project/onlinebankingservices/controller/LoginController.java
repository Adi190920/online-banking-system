package com.project.onlinebankingservices.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.exceptions.NotFoundException;
import com.project.onlinebankingservices.model.Logindata;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.service.UserdtlsService;

@CrossOrigin
@RestController
public class LoginController {

	@Autowired
	private UserdtlsService uservice;

	@PostMapping("/login")
	public ResponseEntity<User> loginApi(@RequestBody Logindata data) throws NotFoundException {

		Optional<User> userOp = uservice.findUserByUsername(data.getUsername());

		if (userOp.isEmpty())
			throw new NotFoundException("Not found Username :" + data.getUsername());

		User user = userOp.get();

		if (!(user.getPassword().equals(data.getPassword())))
			throw new NotFoundException("Incorrect Password for the Username: " + data.getUsername());

		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

}

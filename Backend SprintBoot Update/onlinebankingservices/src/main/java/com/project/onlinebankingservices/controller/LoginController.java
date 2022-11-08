package com.project.onlinebankingservices.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.model.Logindata;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.service.UserdtlsService;

@CrossOrigin
@RestController
public class LoginController {

	@Autowired
	private UserdtlsService uservice;
	@PostMapping("/login")
	public ResponseEntity<User> loginApi(@RequestBody Logindata data){
		
		Optional<User> userOp = uservice.findUserByUsername(data.getUsername());
		
		
		if (userOp.isPresent()) {
			User user = userOp.get();

			if (user.getPassword().equals(data.getPassword())) {
				return new ResponseEntity<User>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			}
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);

	}
	

}


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
import com.project.onlinebankingservices.model.ResetPassword;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.service.UserdtlsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class ResetController {

	@Autowired
	private UserdtlsService uservice;

	// optional to check old password equal to new password
	
	@PostMapping("/reset")
	public ResponseEntity<ResetPassword> reset(@RequestBody ResetPassword rp) throws NotFoundException {

		Optional<User> user = uservice.findUser(rp.getAccountnumber());

		if (user.isEmpty())
			throw new NotFoundException("Not found User with Account Number :" + rp.getAccountnumber());
			
			
		User customer = user.get();

		if (customer.getSecurityanswers().equals(rp.getSecurityanswers())) {

			uservice.updateUserPassword(rp.getNewpassword(), customer.getAccountnumber());
			
			return new ResponseEntity<ResetPassword>(HttpStatus.OK);
		}
		else
			throw new NotFoundException("Incorrect Security Answers");
	

	}
}

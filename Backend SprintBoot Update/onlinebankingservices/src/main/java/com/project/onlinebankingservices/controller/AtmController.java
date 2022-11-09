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
import com.project.onlinebankingservices.model.Atm;
import com.project.onlinebankingservices.model.AtmPinChange;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.service.AtmdtlsService;
import com.project.onlinebankingservices.service.UserdtlsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AtmController {

	@Autowired
	private AtmdtlsService aservice;

	@Autowired
	private UserdtlsService uservice;

	@PostMapping("/changepin")
	public ResponseEntity<AtmPinChange> changePin(@RequestBody AtmPinChange customer) throws NotFoundException {

		Optional<User> userOp = uservice.findUserByUsername(customer.getUsername());

		if(userOp.isEmpty())
			throw new NotFoundException("Not found Username :" + customer.getUsername());
		
		if (!(customer.getNewpin() == customer.getConformpin())) {
			throw new NotFoundException("Incorrect Security Answers");
		}
		
		User user = userOp.get();
		if (aservice.findAtmDetails(user.getAccountnumber()).isPresent()) {

			aservice.updateDetails(user.getAccountnumber(), customer.getNewpin());
			return new ResponseEntity<AtmPinChange> (customer,HttpStatus.OK);
		}

		else {
			Atm atm = new Atm();
			atm.setAccountnumber(user.getAccountnumber());
			atm.setAtmpin(customer.getNewpin());
			aservice.createPinDetails(atm);
			return new ResponseEntity<AtmPinChange> (customer,HttpStatus.OK);
		}
		
	}

}

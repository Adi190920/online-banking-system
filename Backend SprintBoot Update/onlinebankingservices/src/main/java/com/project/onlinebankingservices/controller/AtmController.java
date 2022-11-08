package com.project.onlinebankingservices.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.model.Atm;
import com.project.onlinebankingservices.model.AtmPinChange;
import com.project.onlinebankingservices.model.LoginUser;
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
	public ResponseEntity<AtmPinChange> changePin(@RequestBody AtmPinChange customer) {

//		LoginUser loginuser = new LoginUser();
		Optional<User> userOp = uservice.findUserByUsername(customer.getUsername());
		
		if(userOp.isEmpty())
			return new ResponseEntity<AtmPinChange> (HttpStatus.NOT_FOUND);
		
//		System.out.println(aservice.AtmDetailsByAcc(user.getAccountnumber()));

//		if (!(customer.getNewpin() == customer.getConformpin())) {
//			return new ResponseEntity<AtmPinChange> (HttpStatus.CONFLICT);
//		}
		
		User user = userOp.get();
		if (aservice.findAtmDetails(user.getAccountnumber()).isPresent()) {

			if ((aservice.updateDetails(user.getAccountnumber(), customer.getNewpin())) == 0) {
				return new ResponseEntity<AtmPinChange> (HttpStatus.CONFLICT);
			}

		}

		else {
			Atm atm = new Atm();
			atm.setAccountnumber(user.getAccountnumber());
			atm.setAtmpin(customer.getNewpin());
			aservice.createPinDetails(atm);
		}
		return new ResponseEntity<AtmPinChange> (HttpStatus.OK);
	}

}

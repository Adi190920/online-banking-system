package com.project.onlinebankingservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.model.Fixeddeposit;
import com.project.onlinebankingservices.service.FixeddepositsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FixedDepositController {

	@Autowired
	private FixeddepositsService fixedDepositService;

	@PostMapping("/fixeddeposit")
	public ResponseEntity<Fixeddeposit> newFixedDeposit(@RequestBody Fixeddeposit user) {
//		System.out.println(user);
		try {
		fixedDepositService.createFixedDeposit(user);
		return new ResponseEntity<Fixeddeposit>(user,HttpStatus.OK);
		}
		catch(Exception e)
		{	
			return new ResponseEntity<Fixeddeposit>(user,HttpStatus.INTERNAL_SERVER_ERROR);
				
		}
	}
	
	@GetMapping("/allfd")
	public ResponseEntity<List<Fixeddeposit>> getAllFixedDeposits() {

		return new ResponseEntity<List<Fixeddeposit>> (fixedDepositService.getAll(),HttpStatus.OK);
	}

}

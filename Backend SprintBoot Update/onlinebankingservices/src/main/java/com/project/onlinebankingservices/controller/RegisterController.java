package com.project.onlinebankingservices.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.dto.UsersDto;
import com.project.onlinebankingservices.model.Balance;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.service.AccountsdtlsService;
import com.project.onlinebankingservices.service.BalancedtlsService;
import com.project.onlinebankingservices.service.UserdtlsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class RegisterController {

	
	@Autowired
	private UserdtlsService userService;
	
	@Autowired
	private BalancedtlsService balanceService;
	
	@Autowired
	private AccountsdtlsService accountService;
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user) {
		
	if(accountService.findById(user.getAcctypeid()).isEmpty())
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		
	 if (userService.findUser(user.getAccountnumber()).isPresent())
	 {
		 return new ResponseEntity<User>(HttpStatus.ALREADY_REPORTED);
	 }
		System.out.println(user);
	 	Balance balance = new Balance();
	 	
//	 	System.out.println(balance.getBalanceid());
	 	balance.setAccountnumber(user.getAccountnumber());
	 	balance.setBalance(0);
	 	balanceService.createBalanceDetails(balance);
//	 	balanceService.createBalanceDetails(balance);
//	 	Optional<Balance> b = balanceService.findByAccountnumber(user.getAccountnumber());
		user.setBalanceid(balance.getBalanceid());
		System.out.println(user);
	 	userService.createUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
		
	}
	

}

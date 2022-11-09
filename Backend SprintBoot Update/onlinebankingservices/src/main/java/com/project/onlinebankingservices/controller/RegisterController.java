package com.project.onlinebankingservices.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.exceptions.AlreadyFoundException;
import com.project.onlinebankingservices.exceptions.NotFoundException;
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
	public ResponseEntity<User> register(@RequestBody User user) throws NotFoundException, AlreadyFoundException {

		if (accountService.findById(user.getAcctypeid()).isEmpty())
			throw new NotFoundException("Not found Account Id :" + user.getAcctypeid());

		if (userService.findUser(user.getAccountnumber()).isPresent()) {
			throw new AlreadyFoundException("Can't Create User. (Already exists)  Account Id :" + user.getAcctypeid());
		}
		if (userService.findUserByUsername(user.getUsername()).isPresent()) {
			throw new AlreadyFoundException("Can't Create User. (Already exists)  UserName :" + user.getUsername());
		}

		System.out.println(user);
		Balance balance = new Balance();
		balance.setAccountnumber(user.getAccountnumber());

		balance.setBalance(10000);
		balanceService.createBalanceDetails(balance);

		Optional<Balance> bOps = balanceService.findByAccountnumber(user.getAccountnumber());
		Balance b = bOps.get();

		user.setBalanceid(b.getBalanceid());
		System.out.println(user);
		userService.createUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

}

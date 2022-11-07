package com.project.onlinebankingservices.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.model.LoginUser;
import com.project.onlinebankingservices.model.Transactions;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.service.TransactionsdtlsService;
import com.project.onlinebankingservices.service.UserdtlsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class TransactionsController {

	@Autowired
	private TransactionsdtlsService tservice;

	@Autowired
	private UserdtlsService uservice;

	@GetMapping("/transcations")
	public List<Transactions> transactionsDisplay() {
		// Fetch by Limit

		LoginUser loginuser = new LoginUser();
		Optional<User> userOp = uservice.findUserByUsername(loginuser.getLoginUsername());
		if (userOp.isPresent()) {
			User user = userOp.get();
			System.out.println(user.getAccountnumber());
			List<Transactions> transactionslist = tservice.findByAccountnumber(user.getAccountnumber());
			// System.out.println(transactionslist);

			return transactionslist;
		} else {
			return new ArrayList<>();
		}

	}
}

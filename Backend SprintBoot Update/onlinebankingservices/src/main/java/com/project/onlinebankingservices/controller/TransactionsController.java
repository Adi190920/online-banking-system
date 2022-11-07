package com.project.onlinebankingservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public List<Transactions> transactionsDisplay()
	{
		//Fetch by Limit
		
		LoginUser loginuser = new LoginUser();
		User user = uservice.findUserByUsername(loginuser.getLoginUsername());
//		System.out.println(user.getAccountnumber());
		List<Transactions> transactionslist = tservice.findByAccountnumber(user.getAccountnumber());
//		System.out.println(transactionslist);
		
		return transactionslist;
	}
	
	
}

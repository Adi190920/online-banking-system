package com.project.onlinebankingservices.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.model.Transactions;
import com.project.onlinebankingservices.service.TransactionsdtlsService;
import com.project.onlinebankingservices.service.UserdtlsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class TransactionsController {

	@Autowired
	private TransactionsdtlsService tservice;


	@GetMapping("/transactions")
	public List<Transactions> transactionsDisplay(@RequestBody Map<String,String> accountNumber) {

		List<Transactions> transactionslist = tservice.findByAccountnumber(Long.valueOf(accountNumber.get("accountNumber")));


		return transactionslist;
	}
}
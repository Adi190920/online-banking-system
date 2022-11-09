package com.project.onlinebankingservices.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.model.ReqquestBody;
import com.project.onlinebankingservices.model.Transactions;
import com.project.onlinebankingservices.service.TransactionsdtlsService;
import com.project.onlinebankingservices.service.UserdtlsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class TransactionsController {

	@Autowired
	private TransactionsdtlsService tservice;


	@PostMapping("/transactions")
	public ResponseEntity<List<Transactions>> transactionsDisplay(@RequestBody ReqquestBody requestBody) {

		List<Transactions> transactionslist = tservice.findByAccountnumber(Long.valueOf(requestBody.getAccountNumber()));

		return new ResponseEntity<List<Transactions>>(transactionslist,HttpStatus.OK);
				
	}
}
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

import com.project.onlinebankingservices.model.LoginUser;
import com.project.onlinebankingservices.model.ReqquestBody;
import com.project.onlinebankingservices.model.Balance;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.service.BalancedtlsService;
import com.project.onlinebankingservices.service.UserdtlsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class BalanceController {

	@Autowired
	private BalancedtlsService bservice;

	@PostMapping("/balance")
	public ResponseEntity<Balance> balanceDisplay(@RequestBody ReqquestBody requestBody) {
		// Fetch by Limit
		System.out.println(requestBody);
		Optional<Balance> balancelist = bservice.findByAccountnumber(Long.valueOf(requestBody.getAccountNumber()));
		// System.out.println(transactionslist);

		return new ResponseEntity(balancelist,HttpStatus.OK);

	}
}

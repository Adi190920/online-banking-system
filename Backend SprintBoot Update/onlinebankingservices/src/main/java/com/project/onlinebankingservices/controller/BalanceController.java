package com.project.onlinebankingservices.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.model.LoginUser;
import com.project.onlinebankingservices.model.Balance;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.service.BalancedtlsService;
import com.project.onlinebankingservices.service.UserdtlsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class BalanceController {

	@Autowired
	private BalancedtlsService bservice;

	@GetMapping("/balance")
	public Optional<Balance> balanceDisplay(@RequestBody Map<String,String> accountNumber) {
		// Fetch by Limit
		System.out.println(accountNumber);
		Optional<Balance> balancelist = bservice.findByAccountnumber(Long.valueOf(accountNumber.get("accountnumber")));
		// System.out.println(transactionslist);

		return balancelist;

	}
}

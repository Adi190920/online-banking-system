package com.project.onlinebankingservices.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.model.Balance;
import com.project.onlinebankingservices.model.ReqquestBody;
import com.project.onlinebankingservices.service.BalancedtlsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class BalanceController {

	@Autowired
	private BalancedtlsService bservice;

	@PostMapping("/balance")
	public ResponseEntity<Balance> balanceDisplay(@RequestBody ReqquestBody requestBody) {
		System.out.println(requestBody);
		Optional<Balance> balancelist = bservice.findByAccountnumber(Long.valueOf(requestBody.getAccountNumber()));
		return new ResponseEntity(balancelist, HttpStatus.OK);

	}
}

package com.project.onlinebankingservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.model.Accounts;
import com.project.onlinebankingservices.service.AccountsdtlsServiceImpl;

@RestController
@CrossOrigin
public class AccTypeController {

	@Autowired
	AccountsdtlsServiceImpl accountsdtlsServiceImpl;
	
	@GetMapping("/acctype")
	public ResponseEntity<List<Accounts>> getAccType(){
		List<Accounts> accounts = accountsdtlsServiceImpl.findAll();
		return new ResponseEntity(accounts, HttpStatus.OK);
	}
}

package com.project.onlinebankingservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.model.FundTransfer;
import com.project.onlinebankingservices.service.FundTransferdtlsService;

@RestController
public class FundTransferController {
	@Autowired
	FundTransferdtlsService ftService;
	@PostMapping("/fundtransfer")
	public String fundTransfer(@RequestBody FundTransfer ft) {
		return ftService.doFundTransfer(ft);
		
	}

}

package com.project.onlinebankingservices.service;

import com.project.onlinebankingservices.model.FundTransfer;
import org.springframework.http.ResponseEntity;

public interface FundTransferdtlsService {
	public ResponseEntity<String> doFundTransfer(FundTransfer ft);

}

package com.project.onlinebankingservices.service;

import java.util.List;

import com.project.onlinebankingservices.model.Transactions;

public interface TransactionsdtlsService {

	List<Transactions> findByAccountnumber(Long accountnumber);
	Transactions createTransaction(Transactions transaction);
}
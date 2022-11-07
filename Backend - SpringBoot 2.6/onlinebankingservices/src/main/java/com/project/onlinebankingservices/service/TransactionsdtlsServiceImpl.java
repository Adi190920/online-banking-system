package com.project.onlinebankingservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.onlinebankingservices.model.Transactions;
import com.project.onlinebankingservices.respository.Transactionsdtls;

@Service
public class TransactionsdtlsServiceImpl implements TransactionsdtlsService {

	@Autowired
	private Transactionsdtls repository;

	@Override
	public List<Transactions> findByAccountnumber(Long Accountnumber) {
		return repository.findByAccountnumber(Accountnumber);
	}

	@Override
	public Transactions createTransaction(Transactions transaction) {
		return repository.save(transaction);
	}	
	
}

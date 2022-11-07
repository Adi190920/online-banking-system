package com.project.onlinebankingservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.onlinebankingservices.model.Balance;
import com.project.onlinebankingservices.respository.Balancedtls;

@Service
public class BalancedtlsServiceImp implements BalancedtlsService {

	@Autowired
	private Balancedtls repository;

	@Override
	public Balance createBalanceDetails(Balance balancedetails) {
		return repository.save(balancedetails);
	}

	@Override
	public int UpdateBalanceDetails(int amount, Long accountnumber) {
		return repository.updateBalance(amount, accountnumber);
	}


	@Override
	public Optional<Balance> findByAccountnumber(Long accountnumber) {
		return repository.findByAccountnumber(accountnumber);
	}

}

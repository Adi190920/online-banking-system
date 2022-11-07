package com.project.onlinebankingservices.service;

import java.util.Optional;

import com.project.onlinebankingservices.model.Balance;

public interface BalancedtlsService {

	Balance createBalanceDetails(Balance balancedetails);

	int UpdateBalanceDetails(int amount, Long accountnumber);

	Optional<Balance> findByAccountnumber(Long accountnumber);
	
}
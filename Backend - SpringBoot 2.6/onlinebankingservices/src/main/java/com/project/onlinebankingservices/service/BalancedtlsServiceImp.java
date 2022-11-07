package com.project.onlinebankingservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.onlinebankingservices.model.Balance;
import com.project.onlinebankingservices.respository.Balancedtls;

@Service
public class BalancedtlsServiceImp {

	@Autowired
	private Balancedtls repository;
	
	public Balance createBalanceDetails(Balance balancedetails)
	{
		return repository.save(balancedetails);
	}
	
	public int UpdateBalanceDetails(int amount,long accountnumber)
	{
		return repository.updateBalance(amount,accountnumber);
	}
	
}

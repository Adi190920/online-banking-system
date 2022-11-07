package com.project.onlinebankingservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.onlinebankingservices.model.Accounts;
import com.project.onlinebankingservices.respository.Accountsdtls;

@Service
public class AccountsdtlsServiceImpl implements AccountsdtlsService{

	@Autowired
	private Accountsdtls repository;

	@Override
	public Optional<Accounts> findById(int acctypeid)
	{
		return repository.findById(acctypeid);
	}
	
}

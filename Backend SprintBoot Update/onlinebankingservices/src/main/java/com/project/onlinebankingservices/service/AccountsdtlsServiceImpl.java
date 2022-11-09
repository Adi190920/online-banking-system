package com.project.onlinebankingservices.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.onlinebankingservices.model.Accounts;
import com.project.onlinebankingservices.respository.Accountsdtls;

import antlr.collections.List;

@Service
public class AccountsdtlsServiceImpl implements AccountsdtlsService{

	@Autowired
	private Accountsdtls repository;

	@Override
	public Optional<Accounts> findById(int acctypeid)
	{
		return repository.findById(acctypeid);
	}
	
	

	public java.util.List<Accounts> findAll() {
		// TODO Auto-generated method stub
		return  repository.findAll();
	}
}

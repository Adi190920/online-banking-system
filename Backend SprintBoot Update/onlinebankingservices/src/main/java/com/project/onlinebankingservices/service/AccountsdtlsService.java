package com.project.onlinebankingservices.service;

import java.util.Optional;

import com.project.onlinebankingservices.model.Accounts;

import antlr.collections.List;

public interface AccountsdtlsService {

	Optional<Accounts> findById(int acctypeid);
	java.util.List<Accounts> findAll();

}
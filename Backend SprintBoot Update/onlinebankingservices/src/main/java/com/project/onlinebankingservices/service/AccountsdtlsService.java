package com.project.onlinebankingservices.service;

import java.util.List;
import java.util.Optional;

import com.project.onlinebankingservices.model.Accounts;



public interface AccountsdtlsService {


	Optional<Accounts> findById(int acctypeid) ;

	List<Accounts> findAll();
}
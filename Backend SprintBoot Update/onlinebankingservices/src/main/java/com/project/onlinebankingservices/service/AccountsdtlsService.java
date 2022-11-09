package com.project.onlinebankingservices.service;

import java.util.Optional;

import com.project.onlinebankingservices.exceptions.NotFoundException;
import com.project.onlinebankingservices.model.Accounts;

public interface AccountsdtlsService {

	Optional<Accounts> findById(int acctypeid) ;

}
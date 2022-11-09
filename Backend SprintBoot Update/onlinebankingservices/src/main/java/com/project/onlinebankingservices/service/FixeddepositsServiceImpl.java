package com.project.onlinebankingservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.onlinebankingservices.model.Fixeddeposit;
import com.project.onlinebankingservices.respository.Fixeddepositdtls;

@Service
public class FixeddepositsServiceImpl implements FixeddepositsService {

	@Autowired
	private Fixeddepositdtls repository;

	@Override
	public List<Fixeddeposit> getAll() {
		return repository.findAll();
	}

	@Override
	public Fixeddeposit createFixedDeposit(Fixeddeposit fd) {
		return repository.save(fd);
	}
}

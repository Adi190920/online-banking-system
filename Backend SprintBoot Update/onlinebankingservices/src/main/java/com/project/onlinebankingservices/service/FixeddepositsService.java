package com.project.onlinebankingservices.service;

import java.util.List;

import com.project.onlinebankingservices.model.Fixeddeposit;

public interface FixeddepositsService {

	List<Fixeddeposit> getAll();

	Fixeddeposit createFixedDeposit(Fixeddeposit fd);

}
package com.project.onlinebankingservices.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.project.onlinebankingservices.exceptions.NotFoundException;
import com.project.onlinebankingservices.model.Fixeddeposit;

public interface FixeddepositsService {

	List<Fixeddeposit> getAll();

	ResponseEntity<Fixeddeposit> createFixedDeposit(Fixeddeposit fd) throws NotFoundException;

}
package com.project.onlinebankingservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.onlinebankingservices.exceptions.NotFoundException;
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
	public ResponseEntity<Fixeddeposit> createFixedDeposit(Fixeddeposit user) throws NotFoundException {
		
		try {
			repository.save(user);
			return new ResponseEntity<Fixeddeposit>(user,HttpStatus.OK);
		}
		catch(Exception e)
		{	
			throw new NotFoundException("user is null");
				
		}
		
	}
}

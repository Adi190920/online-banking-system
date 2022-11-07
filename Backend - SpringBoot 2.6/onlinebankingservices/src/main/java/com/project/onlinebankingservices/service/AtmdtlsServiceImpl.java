package com.project.onlinebankingservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.onlinebankingservices.model.Atmdetails;
import com.project.onlinebankingservices.respository.Atmdtls;

@Service
public class AtmdtlsServiceImpl implements AtmdtlsService {

	@Autowired
	private Atmdtls repository;
	
	@Override
	public Optional<Atmdetails> findAtmdtls(long accountnumber)
	{
		return repository.findByAccountnumber(accountnumber);
	}
	
	@Override
	public int updatedtls(long accountnumber, int atmpin)
	{
		return repository.updateNewPin(atmpin,accountnumber);
	}
	
	@Override
	public Atmdetails createPinDetails(Atmdetails atm)
	{
		
		return repository.save(atm);
	}
	
	@Override
	public Optional<Atmdetails> AtmDetailsByAcc(long accountnumber)
	{
		return repository.getAtmDetailsByAccNum(accountnumber);
	}
}

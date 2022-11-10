package com.project.onlinebankingservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.onlinebankingservices.exceptions.NotFoundException;
import com.project.onlinebankingservices.model.Atm;
import com.project.onlinebankingservices.model.AtmPinChange;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.respository.Atmdtls;
import com.project.onlinebankingservices.respository.Usersdtls;

@Service
public class ChangePinServiceImpl implements ChangePinService {

	@Autowired
	private Usersdtls repository;

	@Autowired
	private Atmdtls ares;

	@Override
	public ResponseEntity<AtmPinChange> doChangePin(AtmPinChange customer) throws NotFoundException {
//		Optional<User> userOp = repository.findByUsername(customer.getUsername());
		Optional<User> userOp = repository.findByUsername("wfcp");

		if (userOp.isEmpty())
			throw new NotFoundException("Not found Username :" + customer.getUsername());

		if (!(customer.getNewpin() == customer.getConformpin())) {
			throw new NotFoundException("new pin and conform pin isn't matched");
		}

		User user = userOp.get();
		Optional<Atm> atmOp = ares.findByAccountnumber(user.getAccountnumber());
		if (atmOp.isPresent()) {
			if (atmOp.get().getAtmpin() == customer.getOldpin()) {
				ares.updateNewPin(customer.getNewpin(), user.getAccountnumber());
				return new ResponseEntity<AtmPinChange>(customer, HttpStatus.OK);
			} else
				throw new NotFoundException("Old Pin isn't matched with the DataBase");
		}

		else {
			Atm atm = new Atm();
			atm.setAccountnumber(user.getAccountnumber());
			atm.setAtmpin(customer.getNewpin());
			ares.save(atm);
			return new ResponseEntity<AtmPinChange>(customer, HttpStatus.OK);
		}

	}
}

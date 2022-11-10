package com.project.onlinebankingservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.onlinebankingservices.exceptions.NotFoundException;
import com.project.onlinebankingservices.model.ResetPassword;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.respository.Usersdtls;

@Service
public class ResetServiceImpl implements ResetService {

	@Autowired
	private Usersdtls userRepo;

	@Override
	public ResponseEntity<ResetPassword> doRest(ResetPassword rp) throws NotFoundException {
		Optional<User> user = userRepo.findById(rp.getAccountnumber());

		if (user.isEmpty())
			throw new NotFoundException("Not found User with Account Number :" + rp.getAccountnumber());

		User customer = user.get();

		if (customer.getSecurityanswers().equals(rp.getSecurityanswers())) {

			userRepo.updateUserPassword(rp.getNewpassword(), customer.getAccountnumber());

			return new ResponseEntity<ResetPassword>(HttpStatus.OK);
		} else
			throw new NotFoundException("Incorrect Security Answers");

	}
}

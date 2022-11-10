package com.project.onlinebankingservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.onlinebankingservices.exceptions.NotFoundException;
import com.project.onlinebankingservices.model.Logindata;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.respository.Usersdtls;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private Usersdtls repository;

	@Override
	public ResponseEntity<User> getloggedin(Logindata data) throws NotFoundException

	{
		Optional<User> userOp = repository.findByUsername(data.getUsername());

		if (userOp.isEmpty())
			throw new NotFoundException("Not found Username :" + data.getUsername());

		User user = userOp.get();

		if (!(user.getPassword().equals(data.getPassword())))
			throw new NotFoundException("Incorrect Password for the Username: " + data.getUsername());

		return new ResponseEntity<User>(user, HttpStatus.OK);
		

	}
}

package com.project.onlinebankingservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.onlinebankingservices.exceptions.AlreadyFoundException;
import com.project.onlinebankingservices.exceptions.NotFoundException;
import com.project.onlinebankingservices.model.Balance;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.respository.Accountsdtls;
import com.project.onlinebankingservices.respository.Balancedtls;
import com.project.onlinebankingservices.respository.Usersdtls;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private Usersdtls userRepo;

	@Autowired
	private Balancedtls balanceRepo;

	@Autowired
	private Accountsdtls accountRepo;

	@Override
	public ResponseEntity<User> doRegister(User user) throws NotFoundException, AlreadyFoundException {
		System.out.println(user);
		if (accountRepo.findById(user.getAcctypeid()).isEmpty())
			throw new NotFoundException("Not found Account Id :" + user.getAcctypeid());

		if (userRepo.findById(user.getAccountnumber()).isPresent()) {
			throw new AlreadyFoundException(
					"Can't Create User. (Already exists)  Account Number :" + user.getAccountnumber());
		}
		if (userRepo.findByUsername(user.getUsername()).isPresent()) {
			throw new AlreadyFoundException("Can't Create User. (Already exists)  UserName :" + user.getUsername());
		}

		System.out.println(user);
		Balance balance = new Balance();
		balance.setAccountnumber(user.getAccountnumber());

		balance.setBalance(10000);
		balanceRepo.save(balance);

		Optional<Balance> bOps = balanceRepo.findByAccountnumber(user.getAccountnumber());
		Balance b = bOps.get();

		user.setBalanceid(b.getBalanceid());
		System.out.println(user);
		userRepo.save(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}
}

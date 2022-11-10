package com.project.onlinebankingservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.onlinebankingservices.exceptions.NotFoundException;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.respository.Usersdtls;

@Service
public class UserdtlsServiceImpl implements UserdtlsService {

	@Autowired
	private Usersdtls respository;

	public User createUser(User user) {
		return respository.save(user);
	}

	public List<User> getUsers() {
		return respository.findAll();
	}

	public Optional<User> findUser(long accountNumber) {

		return respository.findById(accountNumber);

	}

	public void deleteUser(long accountNumber) {
		respository.deleteById(accountNumber);
	}

	public Optional<User> findUserByUsername(String username) {

		return respository.findByUsername(username);

	}

	public int updateUserPassword(String password, Long accountNumber) {
		return respository.updateUserPassword(password, accountNumber);
	}

}

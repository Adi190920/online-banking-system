package com.project.onlinebankingservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.respository.Usersdtls;

@org.springframework.stereotype.Service
public class UserdtlsServiceImpl implements UserdtlsService {

	@Autowired
	private Usersdtls respository;
	
	
	@Override
	public User registerUser(User user)
	{
		return respository.save(user);
	}
	
	public List<User> getUsers()
	{
		return respository.findAll();
	}
	
	public Optional<User> findUser(long accountNumber)
	{
		return respository.findById(accountNumber);
	}
	
	public void deleteUser(long accountNumber)
	{
		respository.deleteById(accountNumber);
	}
	
}
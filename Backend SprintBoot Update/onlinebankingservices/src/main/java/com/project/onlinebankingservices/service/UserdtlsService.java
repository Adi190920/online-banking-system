package com.project.onlinebankingservices.service;

import java.util.List;
import java.util.Optional;

import com.project.onlinebankingservices.model.User;

public interface UserdtlsService {

	public User registerUser(User user);

	public List<User> getUsers();

	public Optional<User> findUser(long accountNumber);

	public void deleteUser(long accountNumber);

	public User findUserByUsername(String username);

}
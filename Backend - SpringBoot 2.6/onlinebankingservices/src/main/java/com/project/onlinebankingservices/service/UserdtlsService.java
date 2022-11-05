package com.project.onlinebankingservices.service;

import java.util.List;

import com.project.onlinebankingservices.model.User;

public interface UserdtlsService {

	User registerUser(User user);
	List<User> getUsers();

}
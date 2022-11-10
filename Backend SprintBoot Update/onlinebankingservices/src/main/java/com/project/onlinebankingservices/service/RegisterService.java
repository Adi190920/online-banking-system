package com.project.onlinebankingservices.service;

import org.springframework.http.ResponseEntity;

import com.project.onlinebankingservices.exceptions.AlreadyFoundException;
import com.project.onlinebankingservices.exceptions.NotFoundException;
import com.project.onlinebankingservices.model.User;

public interface RegisterService {
	ResponseEntity<User> doRegister(User user) throws NotFoundException, AlreadyFoundException;
}
package com.project.onlinebankingservices.service;

import org.springframework.http.ResponseEntity;

import com.project.onlinebankingservices.exceptions.NotFoundException;
import com.project.onlinebankingservices.model.Logindata;
import com.project.onlinebankingservices.model.User;

public interface LoginService {

	ResponseEntity<User> getloggedin(Logindata data) throws NotFoundException;

}
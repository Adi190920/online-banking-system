package com.project.onlinebankingservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.model.Logindata;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.service.UserdtlsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {

	@Autowired
	private UserdtlsService uservice;

	@GetMapping("/")
	public String Hello() {
		return "Hello World";
	}

	@GetMapping("/home")
	public String Home() {
		return "Home World";
	}

	@GetMapping("/all")
	public List<User> showAllData() {
		return uservice.getUsers();
	}

	@GetMapping("/loggedout")
	public String loggedout() {
		return "Successfully Logout";
	}
	
}	
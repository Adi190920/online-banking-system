package com.project.onlinebankingservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.service.UserdtlsService;

@RestController
public class Controller {


	
	@GetMapping("/")
	public String Hello() {
		return "Hello World";
	}
	
	@GetMapping("/home")
	public String Home() {
		return "Home World";
	}


	@Autowired
	private UserdtlsService uservice;
	
	@PostMapping("/register")
	public User insertPost(@RequestBody User user) {
		 return uservice.registerUser(user);
	}
	

	@GetMapping("/all")
	public List<User> showAllData(){
		System.out.println(uservice.getUsers());
		return uservice.getUsers();
	}
	
	@GetMapping("/loggedout")
	public String loggedout(){
		return "Successfully Logout";
	}
	
	
	
}

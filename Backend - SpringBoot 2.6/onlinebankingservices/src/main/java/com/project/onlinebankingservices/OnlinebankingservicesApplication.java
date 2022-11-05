package com.project.onlinebankingservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.onlinebankingservices.respository.Usersdtls;

@SpringBootApplication
public class OnlinebankingservicesApplication {

	@Autowired
	private Usersdtls repository;
	
	public static void main(String[] args) {
		SpringApplication.run(OnlinebankingservicesApplication.class, args);
	}

}

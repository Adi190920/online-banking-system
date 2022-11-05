package com.project.onlinebankingservices;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.respository.Usersdtls;

@SpringBootApplication
public class OnlinebankingservicesApplication {

	@Autowired
	private Usersdtls repository;
	
//
//
//	public void initidefaults() {
//		List<User> users = Stream.of(new User("Amruth", "Chandra","Gundoju",
//				"amruthchandra","12345678","Whats ur fav color","Blue",123,1234567890))
//				.collect(Collectors.toList());
//	}

	
	public static void main(String[] args) {
		SpringApplication.run(OnlinebankingservicesApplication.class, args);
	}

}

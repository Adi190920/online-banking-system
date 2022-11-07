package com.project.onlinebankingservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.model.LoginUser;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.service.UserdtlsService;
import com.project.onlinebankingservices.service.FundTransferdtlsService;


@RestController
public class Controller {

	@Autowired
	private UserdtlsService uservice;
	
	@Autowired
	private FundTransferdtlsService ftservice;

	// Cross Origin
//	@Bean
//	public WebMvcConfigurer configure() {
//	
//		return new WebMvcConfigurer() {
//	
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/*").allowedOrigins("*") ;
//	
//			}
//		};
//	}

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

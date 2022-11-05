package com.project.onlinebankingservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.project.onlinebankingservices.model.ResetPassword;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.service.UserdtlsService;

@RestController
public class Controller {

	
	
	@Autowired
	private UserdtlsService uservice;
	
	
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
	public List<User> showAllData(){
		return uservice.getUsers();
	}
	
	@GetMapping("/loggedout")
	public String loggedout(){
		return "Successfully Logout";
	}
	
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		
		
		 return uservice.registerUser(user);
	}
	
	
	@PostMapping("/forget")
	public String reset(@RequestBody ResetPassword rp) {
		
		Optional<User> user = uservice.findUser(rp.getAccountnumber());
		if(user!=null)
		{
			//temp
			return "Sucessful";
		}
			
			return "try";
	}
	
	
	
}

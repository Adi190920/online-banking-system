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

<<<<<<< Updated upstream
	
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

=======
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
	
=======
	@PostMapping("/login")
	public ResponseEntity<User> loginApi(@RequestBody Logindata data) {

		System.out.println(data);
		Optional<User> userOp = uservice.findUserByUsername(data.getUsername());

		User user = userOp.get();

		if (user.getPassword().equals(data.getPassword())) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

	}
>>>>>>> Stashed changes
}

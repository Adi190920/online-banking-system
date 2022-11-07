package com.project.onlinebankingservices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class OnlinebankingservicesApplicationTests {

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public PasswordEncoder pEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Test
	void contextLoads() {
		System.out.println(passwordEncoder().encode("admin"));
		System.out.println(passwordEncoder().encode("admin"));
		}
	
	
	

}

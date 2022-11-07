package com.project.onlinebankingservices.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.model.ResetPassword;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.service.UserdtlsService;

@RestController
public class ResetController {

	@Autowired
	private UserdtlsService uservice;

	@PostMapping("/reset")
	public String reset(@RequestBody ResetPassword rp) {

		Optional<User> user = uservice.findUser(rp.getAccountnumber());

		if (user.isPresent()) {
			User customer = user.get();
			System.out.println(rp);
			System.out.println(customer);
			if (customer.getSecurityquestions().equals(rp.getSecurityquestions())
					&& customer.getSecurityanswers().equals(rp.getSecurityanswers())) {
				PasswordEncoder pe = new BCryptPasswordEncoder();
				customer.setPassword(pe.encode(rp.getNewpassword()));
				uservice.deleteUser(rp.getAccountnumber());
				uservice.registerUser(customer);
				return "Sucessful";
			}
		}

		return "try";
	}
}
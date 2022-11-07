package com.project.onlinebankingservices.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.model.Atm;
import com.project.onlinebankingservices.model.AtmPinChange;
import com.project.onlinebankingservices.model.LoginUser;
import com.project.onlinebankingservices.model.User;
import com.project.onlinebankingservices.service.AtmdtlsService;
import com.project.onlinebankingservices.service.UserdtlsService;

@RestController
public class AtmController {

	@Autowired
	private AtmdtlsService aservice;

	@Autowired
	private UserdtlsService uservice;

	@PostMapping("/changepin")
	public String changePin(@RequestBody AtmPinChange customer) {

		LoginUser loginuser = new LoginUser();
		User user = uservice.findUserByUsername(loginuser.getLoginUsername());
		System.out.println(user.getAccountnumber());
		System.out.println(customer.getNewpin());

//		System.out.println(aservice.AtmDetailsByAcc(user.getAccountnumber()));

		if (!(customer.getNewpin() == customer.getConformpin())) {
			return "New Pin and Conformpin are not matched";
		}

		if (aservice.findAtmdtls(user.getAccountnumber()).isPresent()) {

			if ((aservice.updatedtls(user.getAccountnumber(), customer.getNewpin())) == 0) {
				return "Failed to Update";
			}

		}

		else {
			Atm atm = new Atm();
			atm.setAccountnumber(user.getAccountnumber());
			atm.setAtmpin(customer.getNewpin());
			aservice.createPinDetails(atm);
		}
		return "Sucess";
	}

}

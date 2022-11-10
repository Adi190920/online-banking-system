package com.project.onlinebankingservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.exceptions.NotFoundException;
import com.project.onlinebankingservices.model.ResetPassword;
import com.project.onlinebankingservices.service.ResetService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class ResetController {

	@Autowired
	private ResetService ResetService;

	// optional to check old password equal to new password

	@PostMapping("/reset")
	public ResponseEntity<ResetPassword> reset(@RequestBody ResetPassword rp) throws NotFoundException {

		return ResetService.doRest(rp);
	}

}
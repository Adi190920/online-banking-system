package com.project.onlinebankingservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlinebankingservices.exceptions.NotFoundException;
import com.project.onlinebankingservices.model.AtmPinChange;
import com.project.onlinebankingservices.service.ChangePinService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AtmController {

	@Autowired
	private ChangePinService PinService;;

	@PostMapping("/changepin")
	public ResponseEntity<AtmPinChange> changePin(@RequestBody AtmPinChange customer) throws NotFoundException {

		return PinService.doChangePin(customer);

	}
}
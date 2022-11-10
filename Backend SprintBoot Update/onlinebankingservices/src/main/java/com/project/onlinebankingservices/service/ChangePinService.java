package com.project.onlinebankingservices.service;

import org.springframework.http.ResponseEntity;

import com.project.onlinebankingservices.exceptions.NotFoundException;
import com.project.onlinebankingservices.model.AtmPinChange;

public interface ChangePinService {

	ResponseEntity<AtmPinChange> doChangePin(AtmPinChange customer) throws NotFoundException;

}
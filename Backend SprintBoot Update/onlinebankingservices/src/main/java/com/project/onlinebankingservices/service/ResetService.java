package com.project.onlinebankingservices.service;

import org.springframework.http.ResponseEntity;

import com.project.onlinebankingservices.exceptions.NotFoundException;
import com.project.onlinebankingservices.model.ResetPassword;

public interface ResetService {

	ResponseEntity<ResetPassword> doRest(ResetPassword rp) throws NotFoundException;

}
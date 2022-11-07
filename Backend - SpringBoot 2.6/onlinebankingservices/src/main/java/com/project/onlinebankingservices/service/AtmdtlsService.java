package com.project.onlinebankingservices.service;

import java.util.List;
import java.util.Optional;

import com.project.onlinebankingservices.model.Atmdetails;

public interface AtmdtlsService {

	Optional<Atmdetails> findAtmdtls(long accountnumber);

	int updatedtls(long accountnumber, int atmpin);

	Atmdetails createPinDetails(Atmdetails atm);

	Optional<Atmdetails> AtmDetailsByAcc(long accountnumber);
}
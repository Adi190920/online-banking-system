package com.project.onlinebankingservices.service;

import java.util.List;
import java.util.Optional;

import com.project.onlinebankingservices.model.Atm;

public interface AtmdtlsService {

	Optional<Atm> findAtmDetails(long accountnumber);

	int updateDetails(long accountnumber, int atmpin);

	Atm createPinDetails(Atm atm);

	Optional<Atm> AtmDetailsByAcc(long accountnumber);
}
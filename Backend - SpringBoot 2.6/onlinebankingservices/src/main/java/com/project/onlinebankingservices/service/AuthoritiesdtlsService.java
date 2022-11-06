package com.project.onlinebankingservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.onlinebankingservices.model.Authorities;


public interface AuthoritiesdtlsService {

	Authorities registerAuth(Authorities auth);

	List<Authorities> getAllAuths();

	Optional<Authorities> findAuth(long username);

	void deleteAuth(long username);

}
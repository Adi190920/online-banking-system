package com.project.onlinebankingservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.onlinebankingservices.model.Authorities;
import com.project.onlinebankingservices.respository.Authoritiesdtls;

@Service
public class AuthoritiesdtlsServiceImpl implements AuthoritiesdtlsService {

	@Autowired
	private Authoritiesdtls repository;
	
	@Override
	public Authorities registerAuth(Authorities auth)
	{
		return repository.save(auth);
	}

	@Override
	public List<Authorities> getAllAuths()
	{
		return repository.findAll();
	}

	@Override
	public Optional<Authorities> findAuth(long username)
	{
		return repository.findById(username);
	}

	@Override
	public void deleteAuth(long username)
	{
		repository.deleteById(username);
	}
	
}

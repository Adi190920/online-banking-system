package com.project.onlinebankingservices.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.onlinebankingservices.model.Accounts;

@Repository
public interface Accountsdtls extends JpaRepository<Accounts, Integer> {
	
	
}

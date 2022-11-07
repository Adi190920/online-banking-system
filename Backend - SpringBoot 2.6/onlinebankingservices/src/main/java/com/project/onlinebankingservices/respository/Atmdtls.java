package com.project.onlinebankingservices.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.onlinebankingservices.model.Atm;

@Repository
public interface Atmdtls extends JpaRepository<Atm, Integer> {

}

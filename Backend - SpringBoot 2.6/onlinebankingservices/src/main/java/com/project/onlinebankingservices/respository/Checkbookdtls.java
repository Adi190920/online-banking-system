package com.project.onlinebankingservices.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.onlinebankingservices.model.Checkbook;

@Repository
public interface Checkbookdtls extends JpaRepository<Checkbook, Integer> {

}

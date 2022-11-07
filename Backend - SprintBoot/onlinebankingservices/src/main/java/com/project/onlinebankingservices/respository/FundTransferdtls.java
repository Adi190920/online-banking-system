package com.project.onlinebankingservices.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.onlinebankingservices.model.FundTransfer;

@Repository
public interface FundTransferdtls extends JpaRepository<FundTransfer, Integer> {

}

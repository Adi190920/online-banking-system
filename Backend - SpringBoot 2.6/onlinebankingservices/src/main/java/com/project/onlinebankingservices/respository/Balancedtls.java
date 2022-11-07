package com.project.onlinebankingservices.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.onlinebankingservices.model.Balance;

public interface Balancedtls extends JpaRepository<Balance, Integer> {

	@Modifying
	@Query(value = "UPDATE balancedetails SET amount = :am WHERE accountnumber = :acc", nativeQuery = true)
	int updateBalance(@Param("am") Integer amount, @Param("acc") Long accountnumber);
}

package com.project.onlinebankingservices.respository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.onlinebankingservices.model.Balance;
@Repository
@Transactional
public interface Balancedtls extends JpaRepository<Balance, Integer> {

	@Modifying
	@Query(value = "UPDATE balancedetails SET amount = :am WHERE accountnumber = :acc", nativeQuery = true)
	int updateBalance(@Param("am") Integer amount, @Param("acc") Long accountnumber);
	
	@Query(value="Select * from balanceDetails where accountnumber = ?1", nativeQuery = true)
	Optional<Balance> findByAccountnumber(Long Accountnumber);
}

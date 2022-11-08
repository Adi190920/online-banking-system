package com.project.onlinebankingservices.respository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.project.onlinebankingservices.model.Transactions;

@Transactional
@Repository
public interface Transactionsdtls extends JpaRepository<Transactions, Integer> {

//	@Query(value="Select * from transactions where accountnumber = ?1 limit 5", nativeQuery = true)
//	List<Transactions> findByAccountnumber(Long accountnumber);
	
	@Query(value="Select * from transactions where accountnumber = ?1 order by transactiondate asc", nativeQuery = true)
	List<Transactions> findByAccountnumber(Long accountnumber);

}

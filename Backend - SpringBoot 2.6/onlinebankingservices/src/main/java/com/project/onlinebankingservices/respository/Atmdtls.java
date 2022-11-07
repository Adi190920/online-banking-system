package com.project.onlinebankingservices.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.onlinebankingservices.model.Atmdetails;

@Transactional
@Repository
public interface Atmdtls extends JpaRepository<Atmdetails, Integer> {

	Optional<Atmdetails> findByAccountnumber(long accountnumber);

	
	@Modifying
	@Query(value = "UPDATE atmdetails SET atmpin = :pin WHERE accountnumber = :acc", nativeQuery = true)
	int updateNewPin(@Param("pin") Integer atmpin,@Param("acc") Long accountnumber);
	
	

	@Query(value = "select * from atmdetails  where accountnumber = :acc", nativeQuery = true)
	Optional<Atmdetails> getAtmDetailsByAccNum(@Param("acc") Long accountnumber);
	
}

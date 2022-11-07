package com.project.onlinebankingservices.respository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.onlinebankingservices.model.User;

@Transactional
@Repository
public interface Usersdtls extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);
	
	@Modifying
	@Query(value = "UPDATE users SET password = :pass WHERE accountnumber = :acc", nativeQuery = true)
	int updateUserPassword(@Param("pass") String password,@Param("acc") Long accountnumber);
}
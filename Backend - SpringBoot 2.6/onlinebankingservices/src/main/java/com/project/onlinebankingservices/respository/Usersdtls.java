package com.project.onlinebankingservices.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.onlinebankingservices.model.User;

@Repository
public interface Usersdtls extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
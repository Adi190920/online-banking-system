package com.project.onlinebankingservices.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.project.onlinebankingservices.model.Users;


@Repository
public interface  UsersRepository extends JpaRepository<Users, Integer> {

}

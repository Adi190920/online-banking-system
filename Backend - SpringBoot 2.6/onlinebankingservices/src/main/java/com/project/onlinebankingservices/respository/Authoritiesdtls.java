package com.project.onlinebankingservices.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.onlinebankingservices.model.Authorities;

@Repository
public interface Authoritiesdtls extends JpaRepository<Authorities, Long> {

}

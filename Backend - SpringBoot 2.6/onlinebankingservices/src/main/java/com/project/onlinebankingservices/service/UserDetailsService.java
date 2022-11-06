//package com.project.onlinebankingservices.service;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import com.project.onlinebankingservices.model.User;
//import com.project.onlinebankingservices.respository.Usersdtls;
//
//@org.springframework.stereotype.Service
//public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
//
//	@Autowired
//	private Usersdtls repository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////		User user = repository.findbyUserName(username);
////		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
//
//		return new org.springframework.security.core.userdetails.User("foo", "foo", new ArrayList<>());
//	}
//
//}

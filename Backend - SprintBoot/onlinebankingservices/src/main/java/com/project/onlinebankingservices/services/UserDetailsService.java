//package com.project.onlinebankingservices.services;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.project.onlinebankingservices.model.User;
//import com.project.onlinebankingservices.respository.Usersdtls;
//
//public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{
//	
//	@Autowired
//	private Usersdtls repository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////		User user = repository.findbyUserName(username);
////		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
//		
//	return new org.springframework.security.core.userdetails.User("admin","admin",new ArrayList<>());
//	}
//	
// 
//}

package com.project.onlinebankingservices.model;

import org.springframework.security.core.context.SecurityContextHolder;

public class LoginUser {
//	[Username=wfcp, Password=[PROTECTED], Enabled=true, AccountNonExpired=true, credentialsNonExpired=true, AccountNonLocked=true, Granted Authorities=[user]]
	private Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	private String username;
	
	public String getLoginUsername() {
		
	if (principal instanceof User)
		username = ((User) principal).getUsername();
	else
		username = principal.toString();

	return (username);
}}
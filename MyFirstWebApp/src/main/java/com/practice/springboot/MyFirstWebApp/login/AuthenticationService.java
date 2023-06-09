package com.practice.springboot.MyFirstWebApp.login;

import org.springframework.stereotype.Service;

import jakarta.websocket.server.ServerEndpoint;

@Service
public class AuthenticationService {
	private boolean  validpassword;

	public boolean authenticate(String username, String password) {
		boolean validUser = username.equalsIgnoreCase("ashwini");
		boolean validpassword = password.equalsIgnoreCase("dummy");
		
		return validUser && validpassword ;
	}
}

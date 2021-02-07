package com.portfolio.bugtracker.controllers;

import com.portfolio.bugtracker.models.User;
import com.portfolio.bugtracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrentUserEndpoints
{
	@Autowired
	private UserRepository userRepos;
	
	@GetMapping(value = "/getuserinfo", produces = {"application/json"})
	public ResponseEntity<?> getCurrentUserInfo(Authentication auth)
	{
		User user = userRepos.findByUsername(auth.getName());
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getusername", produces = {"application/json"})
	public ResponseEntity<?> getCurrentUsername(Authentication auth)
	{
		return new ResponseEntity<>(auth.getPrincipal(), HttpStatus.OK);
	}
}

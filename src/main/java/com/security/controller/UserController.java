package com.security.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.Customer;
import com.security.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	// all users
	@Autowired
	private UserService userservice;
	
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/get")
	public List<Customer> getAllUsers()
	{
		return this.userservice.getAllUsers();
	}
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{username}")
	// get single user
	public Optional<Customer> getUser(@PathVariable("username") String username)
	{
		return this.userservice.getUser(username);
	}
//	@PostMapping("/add")
//	public Customer add(Customer user)
//	{
//		return this.userservice.addUser(user);
//	}
	
}

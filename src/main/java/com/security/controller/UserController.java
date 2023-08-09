package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.User;
import com.security.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	// all users
	@Autowired
	private UserService userservice;
	
	@GetMapping("/get")
	public List<User> getAllUsers()
	{
		return this.userservice.getAllUsers();
	}
	@GetMapping("/{username}")
	// get single user
	public User getUser(@PathVariable("username") String username)
	{
		return this.userservice.getUser(username);
	}
	@PostMapping("/add")
	public User add(User user)
	{
		return this.userservice.addUser(user);
	}
	
}

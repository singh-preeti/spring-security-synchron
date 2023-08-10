package com.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.model.Customer;
import com.security.repository.UserRepository;

@Service
public class UserService {
  
	@Autowired
	private UserRepository repository;
	
// get all the users
	public List<Customer> getAllUsers()
	{
		return repository.findAll();
	}
// get single user
	public Optional<Customer> getUser(String username)
	{
		return this.repository.findById(username);
	}
// add new user
//	public Customer addUser(Customer user)
//	{
//		this.list.add(user);
//		return user;
//	}
}

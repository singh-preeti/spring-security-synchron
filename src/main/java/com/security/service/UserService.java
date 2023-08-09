package com.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.security.model.User;

@Service
public class UserService {

	//fake user
	List<User> list = new ArrayList<>();
	
	public UserService()
	{
		list.add(new User("Preeti","12345","singhpreety217@gmail.com"));
		list.add(new User("Ekta","12345","ekta216@gmail.com"));
	}
	
// get all the users
	public List<User> getAllUsers()
	{
		return this.list;
	}
// get single user
	public User getUser(String username)
	{
		return this.list.stream().filter((user) -> user.getUsername().equals(username)).findAny().orElse(null);
	}
// add new user
	public User addUser(User user)
	{
		this.list.add(user);
		return user;
	}
}

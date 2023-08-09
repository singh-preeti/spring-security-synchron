package com.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/app")
public class HomeController {

	@GetMapping("/home")
	public String home()
	{
		return "Hi welcome to the webapp";
	}
	@GetMapping("/register")
	public String register()
	{
		return "Hi welcome to the webapp";
	}
	@GetMapping("/login")
	public String login()
	{
		return "Hi welcome to the webapp";
	}
}

package com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.security.model.Customer;
import com.security.repository.UserRepository;

@SpringBootApplication 
public class SecurityDemoApplication implements CommandLineRunner {
@Autowired
	private UserRepository repo;
@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(SecurityDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//user 1
		Customer user = new Customer();
		user.setUsername("Preeti");
		user.setPassword(this.passwordEncoder.encode("welcome"));
		user.setEmail("singhpreety217@gmail.com");
		user.setRole("NORMAL");
		
		this.repo.save(user);
		
		///user 2
		Customer user1 = new Customer();
		user1.setUsername("Manish");
		user1.setPassword(this.passwordEncoder.encode("Amazon"));
		user1.setEmail("singhpreety217@gmail.com");
		user1.setRole("ADMIN");
		
		this.repo.save(user1);
		
		
	}

}

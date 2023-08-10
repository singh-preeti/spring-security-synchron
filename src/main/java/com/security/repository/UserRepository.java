package com.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.model.Customer;

public interface UserRepository extends JpaRepository<Customer,String> {

}

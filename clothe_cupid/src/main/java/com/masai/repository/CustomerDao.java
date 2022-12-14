package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.module.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
	
	public Optional<Customer> findByCustomerId(String customerId);
	
}

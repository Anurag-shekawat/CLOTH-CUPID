package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.module.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, String> {
	
	public Optional<Customer> findByCustomerId(String customerId);
	
}

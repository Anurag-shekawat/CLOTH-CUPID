package com.masai.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.module.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, String> {
	
	public Optional<Customer> findByCustomerId(String customerId);
	
	@Query(nativeQuery = true,value = "select * from Customer c inner join Address a on a.customer_customer_id= c.addresses_address_id where a.city=?1")
	public List<Customer> viewAllCustomers(String location);

	public Optional<Customer> findByEmail(String email);
	public Optional<Customer> findByMobileNumber(String mobile);
	
}

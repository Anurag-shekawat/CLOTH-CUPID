package com.masai.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.module.Address;
import com.masai.module.Customer;

public interface AddressDao extends JpaRepository<Address, Integer> {
	
	

}

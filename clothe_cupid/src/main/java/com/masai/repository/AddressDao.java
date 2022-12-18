package com.masai.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.module.Address;


public interface AddressDao extends JpaRepository<Address, Integer> {
	
	

}

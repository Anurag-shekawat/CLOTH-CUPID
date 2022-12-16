package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.module.Customer;
import com.masai.service.ICustomerService;

@RestController
public class CustomerControler {
	
	@Autowired
	private ICustomerService cService;
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) throws CustomerException {
		
		Customer savedCustomer= cService.addCustomer(customer);
		
		
		return new ResponseEntity<Customer>(savedCustomer,HttpStatus.CREATED);
	}
	@PutMapping("/customers")
	public  ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws CustomerException {
		
		Customer updatedCustomer= cService.updateCustomer(customer);
				
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
		
	}

}


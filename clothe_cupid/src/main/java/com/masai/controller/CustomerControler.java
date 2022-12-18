package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.exception.LogInException;
import com.masai.module.Customer;
import com.masai.module.LoginDTO;
import com.masai.service.ICustomerService;

@RestController
public class CustomerControler {
	
	@Autowired
	private ICustomerService cService;
	
	@PostMapping("/customer/userId")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer,@RequestParam(required = false) String userId,@RequestParam(required = false) String password) throws CustomerException {
		
		Customer savedCustomer= cService.addCustomer(customer,userId,password);
		
		
		return new ResponseEntity<Customer>(savedCustomer,HttpStatus.CREATED);
	}
	
	@PutMapping("/customers")
	public  ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,@RequestParam(required = false) String key) throws CustomerException {

		Customer updatedCustomer= cService.updateCustomer(customer,key);

		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);

	}
	
	@GetMapping("/customer/{c1}")
	public ResponseEntity<Customer> viewProfile(@PathVariable("c1") String c1) throws CustomerException, LogInException {
		Customer customer= cService.viewCustomer(c1);

		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/customer/dto")
	public ResponseEntity<List<Customer>>viewProfile(@RequestBody LoginDTO dto,@RequestParam(required = false)String location) throws CustomerException, LogInException {
		List<Customer> customer= cService.viewAllCustomers(dto,location);

		return new ResponseEntity<List<Customer>>(customer,HttpStatus.OK);
	}
	@DeleteMapping("/DeleteCustomer")
	public ResponseEntity<Customer> DeleteCustomer(@RequestBody Customer c1) throws CustomerException {
		Customer customer= cService.removeCustomer(c1);

		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}

}


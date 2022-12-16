package com.masai.service;

import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.module.Customer;


public interface ICustomerService {
	
	public Customer addCustomer(Customer cust) throws CustomerException;
	
	public Customer updateCustomer(Customer cust) throws CustomerException;
	
	//public Customer removeCustomer(Customer cust) throws CustomerException;
	
	//public Customer viewCustomer(Customer cust) throws CustomerException;
	
	//public List<Customer> viewAllCustomers(String location) throws CustomerException;
	
}
 
package com.masai.service;

import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.exception.LogInException;
import com.masai.module.Customer;
import com.masai.module.LoginDTO;


public interface ICustomerService {
	
	public Customer addCustomer(Customer cust, String id, String password) throws CustomerException;
	
	public Customer updateCustomer(Customer cust,String key) throws CustomerException;
	
	public Customer removeCustomer(Customer cust) throws CustomerException;
	
	public Customer viewCustomer(String Id) throws CustomerException, LogInException;
	
	public List<Customer> viewAllCustomers(LoginDTO dto,String location) throws CustomerException,LogInException;
	
}
 
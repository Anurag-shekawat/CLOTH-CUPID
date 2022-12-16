package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.module.Customer;
import com.masai.module.Users;
import com.masai.repository.CustomerDao;
import com.masai.repository.UserDao;


@Service
public class CustomerService implements ICustomerService{
	
	@Autowired
	private CustomerDao cd;
	
	@Autowired
	private UserDao ud;

	@Override
	public Customer addCustomer(Customer cust) throws CustomerException {
		Optional<Customer>c1= cd.findByCustomerId(cust.getCustomerId());
		if (c1.isPresent()) {
			throw new CustomerException("♣█☻ Already record there ☻█♣");
		}
		else {
			return cd.save(c1.get());
		}
	}

	@Override
	public Customer updateCustomer(Customer cust) throws CustomerException {
		
		Optional<Users> u1= ud.findByUuId(cust.getUser().getUuId());
		
		if(u1.isEmpty()) {
			throw new CustomerException("♣█☻ Invalid Entry ☻█♣");
		}
		
		else {	
			return cd.save(cust);
		}
		
	}

	@Override
	public Customer removeCustomer(Customer cust) throws CustomerException {
		
		Optional<Users> sessionOpt= ud.findByUserId(cust.getCustomerId());
		
		if(sessionOpt.isEmpty()) {
			throw new CustomerException("Login to Delete Account");
		}
		else {
			cd.delete(cust);
			return cust;
		}
		
	}

	@Override
	public Customer viewCustomer(Customer cust) throws CustomerException {
		
		Optional<Customer> sessionOpt= cd.findByCustomerId(cust.getCustomerId());
		
		if(sessionOpt.isEmpty()) {
			throw new CustomerException("Login to view Account");
		}
		else {
			return sessionOpt.get();
		}
	}

	@Override
	public List<Customer> viewAllCustomers(String location) throws CustomerException {
		
//		List<Customer> customer= 
//		
//		if(sessionOpt.isEmpty()) {
//			throw new CustomerException("Login to view Account");
//		}
//		else {
//			return sessionOpt.get();
//		}
		return null;
	}
	
	

}

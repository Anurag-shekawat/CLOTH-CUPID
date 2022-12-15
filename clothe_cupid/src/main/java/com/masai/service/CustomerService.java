package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exception.CustomerException;
import com.masai.module.Customer;
import com.masai.module.Users;
import com.masai.repository.CustomerDao;
import com.masai.repository.UserDao;

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
		
		return null;
	}

	@Override
	public Customer viewCustomer(Customer cust) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> viewAllCustomers(String location) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

package com.masai.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.LogInException;
import com.masai.module.Customer;
import com.masai.module.LoginDTO;
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
	public Customer addCustomer(Customer customer) throws CustomerException {
		Optional<Customer>c1= cd.findByCustomerId(customer.getCustomerId());
		if (c1.isPresent()) {
			throw new CustomerException("♣█☻ Already record there ☻█♣");
		}
			return cd.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer cust) throws CustomerException {

		Optional<Users> u1= ud.findByUuId(cust.getUser().getUuId());

		if(u1.isEmpty()) {
			throw new CustomerException("♣█☻ Invalid Entry ☻█♣");
		}
			cust.setUser(u1.get());
			return cd.save(cust);

	}

	@Override
	public Customer viewCustomer(Customer cust) throws CustomerException, LogInException {

		Optional<Customer> sessionOpt= cd.findByCustomerId(cust.getCustomerId());

		if(sessionOpt.isEmpty()) {
			throw new CustomerException("Login to view Account");
		}
		else if(sessionOpt.get().getUser().getUuId()==null){

			throw new LogInException("♣█☻ Please first login to view profile ☻█♣");
		}
		else {
			return sessionOpt.get();
		}
	}
	@Override
	public List<Customer> viewAllCustomers(LoginDTO dto,String location) throws CustomerException,LogInException {
		List<Customer> customer=null;
		Optional<Customer> admin= cd.findByCustomerId(dto.getUserId());

		if(admin.isEmpty()) {
			throw new CustomerException("No record there");
		}
		else if(admin.get().getPassword().equals(dto.getPassword())){
			throw new LogInException("please enter correct password");
		}

		else if(admin.get().getRole().equals("admin")){
			customer= cd.viewAllCustomers(location);
			return customer;
		}
		return customer;
	}

	@Override
	public Customer removeCustomer(Customer cust) throws CustomerException {
		Optional<Users> u1= ud.findByUuId(cust.getUser().getUuId());

		if(u1.isEmpty()) {
			throw new CustomerException("♣█☻ Invalid Entry ☻█♣");
		}
			cust.setUser(u1.get());
			cd.delete(cust);
			return cust;
	}

	
	

}

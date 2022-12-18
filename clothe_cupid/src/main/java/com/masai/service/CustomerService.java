package com.masai.service;

import java.util.List;
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
	public Customer addCustomer(Customer customer,String id, String password) throws CustomerException {
		Optional<Customer>c1= cd.findByCustomerId(customer.getCustomerId());
		Optional<Customer> c2= cd.findByCustomerId(id);
		if (c1.isPresent()) {
			throw new CustomerException("♣█☻ Already record there ☻█♣");
		}
		else if(c2.isEmpty()){
			throw new CustomerException("♣█☻ Invalid Details ☻█♣");
		}
		else if(!"admin".equals(c2.get().getRole().toLowerCase())){
			throw new CustomerException("♣█☻ Admin can add customer ☻█♣");
		} else if(!c2.get().getPassword().equals(password)) {
			throw new CustomerException("♣█☻ Login first to add users ☻█♣");
		}

		
// 		customer.getAddress().setCustomer(customer);

		return cd.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer cust,String key) throws CustomerException {

		Optional<Users> u1= ud.findByUuId(key);

		if(u1.isEmpty()) {
			throw new CustomerException("♣█☻ Invalid Entry ☻█♣");
		}
			cust.setUser(u1.get());
			return cd.save(cust);

	}

	@Override
	public Customer viewCustomer(String Id) throws CustomerException, LogInException{

		Optional<Customer> sessionOpt= cd.findByCustomerId(Id);

		if(!sessionOpt.isPresent()) {
			throw new CustomerException("♣█☻ Login to view Account ☻█♣");
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
			throw new CustomerException("♣█☻ No record there ☻█♣");
		}
		else if(admin.get().getPassword().equals(dto.getPassword())){
			throw new LogInException("♣█☻ Please enter correct password ☻█♣");
		}

		else if(admin.get().getRole().equals("admin")){
			customer= cd.viewAllCustomers(location);
			return customer;
		}
		return customer;
	}

	@Override
	public Customer removeCustomer(Customer cust) throws CustomerException {

		Optional<Users> sessionOpt= ud.findByUserId(cust.getCustomerId());

		if(sessionOpt.isEmpty()) {
			throw new CustomerException("♣█☻ Login to Delete Account ☻█♣");
		}
		else {
			cd.delete(cust);
			return cust;
		}

	}

	
	

}

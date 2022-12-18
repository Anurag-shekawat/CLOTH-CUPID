package com.masai.service;


import java.time.LocalDateTime;
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

import net.bytebuddy.utility.RandomString;

@Service
public class LogInService implements ILoginService{
	
	@Autowired
	private CustomerDao cDao;
	
	@Autowired
	private UserDao sDao;

	@Override
	public Users logInAccount(LoginDTO dto) throws LogInException {

		Optional<Customer> existingCustomer= cDao.findByCustomerId(dto.getUserId());

		if(existingCustomer.isEmpty()) {

			throw new LogInException("Please Enter a valid UserId");


		}
		Optional<Users> validCustom =  sDao.findByUserId(existingCustomer.get().getCustomerId());

		if(validCustom.isPresent()) {

			throw new LogInException("User already Logged In with this number");

		}

		if(existingCustomer.get().getPassword().equals(dto.getPassword())) {


			return validateUser(existingCustomer.get());
		}
		else
			throw new LogInException("Please Enter a valid password");
	}

	@Override
	public Users logOut(Users u) throws LogInException {

		Optional<Users>validCustomerSession = sDao.findByUuId(u.getUuId());


		if(validCustomerSession.isEmpty()) {
			throw new LogInException("User Not Logged In with this number");

		}

		sDao.delete(validCustomerSession.get());


		return validCustomerSession.get();


	}

	@Override
	public Users validateUser(Customer u) throws LogInException {


		String key= RandomString.make(9);
		Users currentUserSession = new Users(u.getCustomerId(),u.getPassword(),u.getRole(),key,LocalDateTime.now());

		return sDao.save(currentUserSession);

	}
	@Override
	public Users signUp(Customer customer) throws CustomerException, LogInException {
		Optional<Customer>c1= cDao.findByCustomerId(customer.getCustomerId());
		if (c1.isPresent()) {
			throw new CustomerException("♣█☻ Already record there ☻█♣");
		}
		customer.setRole("customer");
		cDao.save(customer);

		return validateUser(customer);
	}
	
	
}

package com.masai.service;


import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		if(existingCustomer == null) {
			
			throw new LogInException("Please Enter a valid mobile number");
			
			 
		}
		Optional<Users> validCustom =  sDao.findByUserId(existingCustomer.get().getCustomerId());
		
		if(validCustom.isPresent()) {
			
			throw new LogInException("User already Logged In with this number");
			
		}
		
		if(existingCustomer.get().getPassword().equals(dto.getPassword())) {
			
			return validateUser(validCustom.get());
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
	public Users validateUser(Users u) throws LogInException {
		
		
		String key= RandomString.make(9);
		Users currentUserSession = new Users(u.getUserId(),u.getPassword(),u.getRole(),key,LocalDateTime.now());
		
		return sDao.save(currentUserSession);
			 	
	}	
	
	
}

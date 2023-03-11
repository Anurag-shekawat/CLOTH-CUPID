package com.masai.service;


import java.time.LocalDateTime;
import java.util.Optional;

import com.masai.module.Admin;
import com.masai.module.UsersSessions;
import com.masai.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.LogInException;
import com.masai.module.Customer;
import com.masai.module.LoginDTO;
import com.masai.repository.CustomerDao;
import com.masai.repository.UserSessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class LogInService implements ILoginService{
	
	@Autowired
	private CustomerDao cDao;
	
	@Autowired
	private UserSessionDao usDao;

	@Autowired
	private AdminRepo aDao;

	@Override
	public UsersSessions logInAccount(LoginDTO dto) throws LogInException {

		Optional<Customer> existingCustomer= cDao.findByEmail(dto.getUserId());
		Optional<Customer> customerWithPhone= cDao.findByMobileNumber(dto.getUserId());

		if(existingCustomer.isPresent() || customerWithPhone.isPresent()) {

			if (existingCustomer.isPresent() && existingCustomer.get().getPassword().equals(dto.getPassword())){
				Optional<UsersSessions> validCustom =  usDao.findByUserId(existingCustomer.get().getCustomerId());
				if(validCustom.isPresent()){
					throw new LogInException("User already Logged In with this ID");
				}
				else{
					String key= RandomString.make(16);
					Customer customer= existingCustomer.get();
					return usDao.save(new UsersSessions(customer.getCustomerId(), customer.getPassword(), "Customer", key, LocalDateTime.now()));
				}
			}
			else if (customerWithPhone.isPresent() && customerWithPhone.get().getPassword().equals(dto.getPassword())){
				Optional<UsersSessions> validCustom =  usDao.findByUserId(customerWithPhone.get().getCustomerId());
				if(validCustom.isPresent()){
					throw new LogInException("User already Logged In with this ID");
				}
				else{
					String key= RandomString.make(16);
					Customer customer= customerWithPhone.get();
					return usDao.save(new UsersSessions(customer.getCustomerId(), customer.getPassword(), "Customer", key, LocalDateTime.now()));
				}
			}
			else{
				throw new LogInException("Incorrect Password");
			}
		}
		else
			throw new LogInException("Please Enter a valid UserId");
	}

	@Override
	public UsersSessions logOut(String key) throws LogInException {

		Optional<UsersSessions>validCustomerSession = usDao.findByUuId(key);

		if(validCustomerSession.isEmpty()) {
			throw new LogInException("♣█☻ Key Error ☻█♣");

		}else{
			usDao.delete(validCustomerSession.get());
			return validCustomerSession.get();
		}

	}

	@Override
	public UsersSessions logInAdmin(LoginDTO dto) throws LogInException {
		Optional<Admin> opAdmin= aDao.findByEmail(dto.getUserId());

		if (opAdmin.isEmpty()){
			throw new LogInException("Incorrect username");
		}
		Optional<UsersSessions> customerActive= usDao.findByUserId(opAdmin.get().getAdminId());
		if(customerActive.isPresent()){
			throw new LogInException("User already Logged In with this Email");
		}
		if(opAdmin.get().getPassword().equals(dto.getPassword())){
			String key= RandomString.make(16);
			Admin admin= opAdmin.get();
			return usDao.save(new UsersSessions(admin.getAdminId(), admin.getPassword(), "Admin", key, LocalDateTime.now()));
		}
		else {
			throw new LogInException("Please Enter a valid password");
		}
	}

	@Override
	public UsersSessions logOutAdmin(String key) throws LogInException {
		Optional<UsersSessions>checkAlreadyIn = usDao.findByUuId(key);

		if(checkAlreadyIn.isEmpty()){
			throw new LogInException("♣█☻ Key Error ☻█♣");
		} else if(checkAlreadyIn.get().getRole().equalsIgnoreCase("admin")) {
			throw new LogInException("♣█☻ Key Error ☻█♣");
		} else {
			usDao.delete(checkAlreadyIn.get());
			return checkAlreadyIn.get();
		}
	}

}

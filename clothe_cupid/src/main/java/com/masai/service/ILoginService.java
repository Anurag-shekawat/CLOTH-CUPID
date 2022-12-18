package com.masai.service;


import com.masai.exception.CustomerException;
import com.masai.exception.LogInException;
import com.masai.module.Customer;
import com.masai.module.LoginDTO;
import com.masai.module.Users;

public interface ILoginService {
	
	public Users logInAccount(LoginDTO dto) throws LogInException;

	public Users logOut(Users u) throws LogInException;

	public Users validateUser(Customer u) throws LogInException;

	public Users signUp(Customer u) throws LogInException, CustomerException;
	

}

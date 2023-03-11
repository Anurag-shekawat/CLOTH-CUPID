package com.masai.service;


import com.masai.exception.CustomerException;
import com.masai.exception.LogInException;
import com.masai.module.Admin;
import com.masai.module.Customer;
import com.masai.module.LoginDTO;
import com.masai.module.UsersSessions;

public interface ILoginService {
	
	public UsersSessions logInAccount(LoginDTO dto) throws LogInException;

	public UsersSessions logOut(String key) throws LogInException;


//8888888888888888888888888888888888888888888888888888888 Admin Features 88888888888888888888888888888888888888888888888888888888888888\\

	public UsersSessions logInAdmin(LoginDTO dto) throws LogInException;

	public UsersSessions logOutAdmin(String key) throws LogInException;


}

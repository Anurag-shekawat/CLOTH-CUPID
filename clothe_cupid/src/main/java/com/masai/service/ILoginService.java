package com.masai.service;


import com.masai.exception.LogInException;
import com.masai.module.LoginDTO;
import com.masai.module.Users;

public interface ILoginService {
	
	public Users logInAccount(LoginDTO dto) throws LogInException;
	
	public Users logOut(Users u) throws LogInException;
	
	public Users validateUser(Users u) throws LogInException;
	

}

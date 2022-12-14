package com.masai.service;

import com.masai.module.LoginDTO;

public interface IloginService {
	
	public String logInAccount(LoginDTO dto) throws LogInException;
	

}

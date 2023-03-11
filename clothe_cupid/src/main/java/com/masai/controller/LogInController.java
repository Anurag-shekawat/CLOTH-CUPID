package com.masai.controller;

import javax.validation.Valid;

import com.masai.module.Admin;
import com.masai.module.UsersSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.masai.exception.CustomerException;
import com.masai.exception.LogInException;
import com.masai.module.Customer;
import com.masai.module.LoginDTO;
import com.masai.service.ILoginService;

@RestController
public class LogInController {
	
	@Autowired
	private ILoginService login;
	
	@PostMapping("Customer/login")
	public ResponseEntity<UsersSessions> logInCustomer(@RequestBody LoginDTO dto) throws LogInException {

		UsersSessions result = login.logInAccount(dto);

		return new ResponseEntity<UsersSessions>(result,HttpStatus.OK );


	}

	@DeleteMapping("Customer/logout")
	public ResponseEntity<UsersSessions> logoutCustomer(@RequestParam(required = false) String key) throws LogInException {
		UsersSessions result = login.logOut(key);

		return new ResponseEntity<UsersSessions>(result,HttpStatus.OK);

	}
	//88888888888888888888888888888888888888888888888888888 Admin Features 8888888888888888888888888888888888888888888888888888888\\
	@PostMapping("/Admin/Login")
	public ResponseEntity<UsersSessions> logInAdmin(@RequestBody LoginDTO dto) throws LogInException{

		UsersSessions adminSession= login.logInAdmin(dto);

		return new ResponseEntity<UsersSessions>(adminSession, HttpStatus.ACCEPTED);
	}
	@DeleteMapping("Admin/LogOut")
	public ResponseEntity<UsersSessions> logOutAdmin(@RequestParam(required = false) String key) throws LogInException{
		UsersSessions adminSession= login.logOutAdmin(key);

		return new ResponseEntity<UsersSessions>(adminSession, HttpStatus.OK);
	}
	


}

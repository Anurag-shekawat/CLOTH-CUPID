package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LogInException;
import com.masai.module.LoginDTO;
import com.masai.module.Users;
import com.masai.service.ILoginService;

@RestController
public class LogInController {
	
	@Autowired
	private ILoginService customerLogin;
	
	@PostMapping("/login")
	public ResponseEntity<Users> logInCustomer(@RequestBody LoginDTO dto) throws LogInException {

		Users result = customerLogin.logInAccount(dto);



		return new ResponseEntity<Users>(result,HttpStatus.OK );


	}

	@DeleteMapping("/logout")
	public ResponseEntity<Users> logoutCustomer(@RequestBody Users u1) throws LogInException {
		Users result = customerLogin.logOut(u1);

		return new ResponseEntity<Users>(result,HttpStatus.OK);

	}

}

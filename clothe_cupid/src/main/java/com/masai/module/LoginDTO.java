package com.masai.module;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoginDTO {
	
	@NotNull(message = "userid cannot be null")
	private String userId;
	
	@NotNull(message = "password cannot be null")
	private String password;

}

package com.masai.module;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
	
	private String CustomerId;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	//private Address address;
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Users user;
	
	

}

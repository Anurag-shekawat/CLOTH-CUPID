package com.masai.module;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "customer")
	private Cart cart;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer",fetch = FetchType.EAGER)
	private List<OrderDetails> details = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "customers")
	private List<Address> addresses = new ArrayList<>();

}

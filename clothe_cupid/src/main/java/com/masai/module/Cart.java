package com.masai.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
//	private Customer customer;
//	private Product product;
	
	
}

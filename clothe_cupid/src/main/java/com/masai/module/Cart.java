package com.masai.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Map<Product, Integer> productList = new HashMap<>();
	
	
}

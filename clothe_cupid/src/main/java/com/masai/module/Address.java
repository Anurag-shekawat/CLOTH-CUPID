package com.masai.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;
	
	private String StreetNo;
	
	private String BuildingName;
	
	private String city;
	
	private String state;
	
	private String Country;
	
	private String pincode;

}

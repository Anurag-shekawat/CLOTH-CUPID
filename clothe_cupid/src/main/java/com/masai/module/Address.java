package com.masai.module;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "address")
	private OrderDetails orderDetails;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Customer> customers = new ArrayList<>();

}

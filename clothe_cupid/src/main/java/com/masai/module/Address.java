package com.masai.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;

	@NotNull(message = "streetNo can not be null")
	private String streetNo;

	@NotNull(message = "building name can not be null")
	private String buildingName;

	@NotNull(message = "city cannot can not be null")
	private String city;

	@NotNull(message = "state can not be null")
	private String state;

	@NotNull(message = "country can not be null")
	private String country;

	@NotNull(message = "pincode can not be null")
	@Max(value = 6,message = "pincode size cannot be greater then 6")
	private String pincode;

	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;

}

package com.masai.module;


import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	@NotBlank(message = "Enter Product Name")
	private String productName;
	
	@NotNull(message = "Enter Product Price")
	private double price;
	
	@NotBlank(message = "Enter Product Dimension")
	private String dimension;
	
	@NotBlank(message = "Enter Product Specification")
	private String specification;
	
	@NotBlank(message = "Enter Product Manufacturer")
	private String manufacturer;
	
	@NotNull(message = "Enter Product Quantity")
	private Integer quantity;
	
	@Embedded
	private Category category;
	
	// @JsonIgnore
	// @ManyToOne(cascade = CascadeType.ALL)
	// private OrderDetails details;
	

}

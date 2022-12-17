package com.masai.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "demo_sql")
	@GenericGenerator(name = "demo_sql",strategy = "com.masai.module.StringSequenceGenerator",parameters = {
			@Parameter(name = StringSequenceGenerator.INCREMENT_PARAM,value="1"),
			@Parameter(name = StringSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "clothe_"),
			@Parameter(name = StringSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
			
	})
	private String customerId;
	
	private String firstName;
	
	private String lastName;
	private String mobileNumber;
	private String email;
	private String password;
	private String role;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	@JsonIgnore
	private Users user;
	
	// @OneToOne(cascade = CascadeType.ALL,mappedBy = "customer")
	// private Cart cart;
	
	// @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer",fetch = FetchType.EAGER)
	// private List<OrderDetails> details = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address ;

}

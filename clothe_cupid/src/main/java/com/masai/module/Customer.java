package com.masai.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.Length;

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
	
	@NotBlank(message = "☻ Please fill First Name ☻")
	private String firstName;
	@NotBlank(message = "☻ Please fill Last Name ☻")
	private String lastName;
	
	@Pattern(message = "☻ Please fill Phone Number ☻",regexp="(^$|[0-9]{10})")
	//@NotBlank(message = "☻ Please fill Phone Number ☻")
	private String mobileNumber;
	@NotBlank(message = "☻ Please fill Email ☻")
	@Email
	private String email;
	@NotBlank(message = "☻ Please fill Password ☻")
	@Size(max = 12,min = 5)
	private String password;
	@NotBlank(message = "☻ Please fill Role ☻")
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
	@JsonIgnore
	private Address address ;

}

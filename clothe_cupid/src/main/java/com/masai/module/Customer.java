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
import javax.validation.constraints.NotNull;
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
	
	@NotNull(message = "first name cannot be null")
	private String firstName;
	
	@NotNull(message = "last name cannot be null")
	private String lastName;
	
	@NotNull(message = "mobile number cannot be null")
	@Pattern(regexp = "[7,8,9]{1}[0-9]{9}",message = "Invalid mobile number")
	private String mobileNumber;
	
	@NotNull(message = "email cannot be null")
	@Email
	private String email;
	
	@NotNull(message = "Password cannot be null")
	@Size(min = 8,max = 15,message = "Password should be min 8 and max 15 character length.")
	private String password;
	
	@NotNull(message = "Role cannot be null")
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

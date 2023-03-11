package com.masai.module;

import java.time.LocalDateTime;

//import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersSessions {
	
	@Id
	private String userId;
	private String password;
	private String role;
	@Column(unique = true)
	private String uuId;
	private LocalDateTime localDateTime;
	
}

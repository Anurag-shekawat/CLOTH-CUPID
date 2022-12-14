package com.masai.module;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	
	@Id
	@Column(unique = true)
	private String userId;
	private String passwordString;
	private String role;
	private String uuId;
	private LocalDateTime localDateTime;
	
}

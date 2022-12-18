package com.masai.module;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Category {

	@NotNull(message = "cartId cannot be null")
	private Integer catId;
	
	@NotNull(message = "category name cannot be null")
	private String categoryName;

}

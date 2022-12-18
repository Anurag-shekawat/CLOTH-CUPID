package com.masai.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.module.Product;
@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	
}

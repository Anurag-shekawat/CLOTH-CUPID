package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.module.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}

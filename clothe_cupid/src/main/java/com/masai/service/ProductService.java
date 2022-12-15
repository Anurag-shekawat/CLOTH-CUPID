package com.masai.service;

import java.util.List;

import com.masai.exception.ProductException;
import com.masai.module.Product;


public interface ProductService  {
	
	public List<Product> viewAllProducts() throws ProductException;
	
	public Product addProduct(Product product)throws ProductException;
	
	public Product updateProduct(Product product)throws ProductException;
	
	public Product viewProduct(Integer pId)throws ProductException;
	
	public List<Product> viewAllProductsByCategory(String cname)throws ProductException;
	
	public Product removeProduct(Integer pId)throws ProductException;
	
	

}

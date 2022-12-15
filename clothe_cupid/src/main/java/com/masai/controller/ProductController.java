package com.masai.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.ProductException;
import com.masai.module.Product;
import com.masai.service.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ProductController {

	
	
	@Autowired
	ProductService pService;
	
	@GetMapping("/product")
	public ResponseEntity<List<Product>> viewAllProduct() throws ProductException{
		
		List<Product> list=pService.viewAllProducts();
		
		return new ResponseEntity<List<Product>>(list,HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws ProductException{
		Product pro=pService.addProduct(product);
		
		return new ResponseEntity<Product>(pro,HttpStatus.OK);
	}
	
	@PutMapping("/product")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) throws ProductException{
		Product pro=pService.updateProduct(product);
		
		return new ResponseEntity<Product>(pro,HttpStatus.ACCEPTED);
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> viewProduct(@PathVariable("id") Integer id) throws ProductException{
		
		Product pro=pService.viewProduct(id);
		
		return new ResponseEntity<Product>(pro,HttpStatus.ACCEPTED);
		
	}
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Product> removeProduct(@PathVariable("id") Integer pid) throws ProductException{
		
		Product pro=pService.removeProduct(pid);
		
		return new ResponseEntity<Product>(pro,HttpStatus.OK);
		
		
	}
	
	
}

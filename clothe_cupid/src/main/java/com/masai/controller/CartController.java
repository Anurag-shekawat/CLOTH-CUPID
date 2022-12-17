package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CartException;
import com.masai.exception.CustomerException;
import com.masai.exception.ProductException;
import com.masai.module.Cart;
import com.masai.module.Product;
import com.masai.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cService;

	 @PostMapping("/addProductTocart")
	 public ResponseEntity<Cart> addProductToCartController(@RequestBody Cart cart,
	 		@RequestParam("prodId") Integer prodId,@RequestParam("custId") String customerId)
	 		throws CartException, ProductException, CustomerException {
	 	Cart newCart = cService.addProductToCart(cart, customerId, prodId);
	 	return new ResponseEntity<Cart>(newCart, HttpStatus.ACCEPTED);
	 }

	@PutMapping("/removeProduct")
	public ResponseEntity<Cart> removeProductFromCartController(@RequestParam("prodId") Integer prodId,
			@RequestParam("cartId") Integer cartId) throws CartException, ProductException {
		Cart newCart = cService.removeProductFromCart(cartId, prodId);
		return new ResponseEntity<Cart>(newCart, HttpStatus.ACCEPTED);
	}

	 @PutMapping("/updateProductQuantity")
	 public ResponseEntity<Cart> updateProductQuantityController(@RequestParam("prodId") Integer prodId,
	 		@RequestParam("cartId") Integer cartId, @RequestParam("quantity") Integer quantity)
	 		throws CartException, ProductException {
	 	Cart newCart = cService.updateProductQuantity(cartId, prodId, quantity);
	 	return new ResponseEntity<Cart>(newCart, HttpStatus.ACCEPTED);
	 }

	@PutMapping("/removeAllProduct")
	public ResponseEntity<Cart> deleteAllProductFromCartController(@RequestParam("cartId") Integer cartId)
			throws CartException, ProductException {
		Cart newCart = cService.removeAllProducts(cartId);
		return new ResponseEntity<Cart>(newCart, HttpStatus.ACCEPTED);
	}
	
	 @GetMapping("/viewAllProduct")
	 public ResponseEntity<List<Product>> viewAllProductHandler(@RequestParam("cartId") Integer cartId) throws CartException, ProductException{
	 	List<Product> products = cService.viewAllProducts(cartId);
	 	return new ResponseEntity<List<Product>>(products,HttpStatus.ACCEPTED);
	 }

}

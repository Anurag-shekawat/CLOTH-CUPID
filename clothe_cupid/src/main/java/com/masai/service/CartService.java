package com.masai.service;

import java.util.List;

import com.masai.exception.CartException;
import com.masai.exception.ProductException;
import com.masai.module.Cart;
import com.masai.module.Product;

public interface CartService {

	public Cart addProductToCart(Cart cart, Integer prodId, Integer quantity)throws CartException,ProductException;
	public Cart removeProductFromCart(Integer cartId,Integer prodId)throws CartException,ProductException;
	public Cart updateProductQuantity(Integer cartId,Integer prodId, int quantity)throws CartException,ProductException;
	public Cart removeAllProducts(Integer cartId)throws CartException;
	public List<Product> viewAllProducts(Integer cartId)throws CartException,ProductException;
	
}

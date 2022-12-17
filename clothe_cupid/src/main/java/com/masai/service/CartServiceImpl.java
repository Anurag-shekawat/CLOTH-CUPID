package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CartException;
import com.masai.exception.CustomerException;
import com.masai.exception.ProductException;
import com.masai.module.Cart;
import com.masai.module.Customer;
import com.masai.module.Product;
import com.masai.repository.CartDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.ProductDao;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private ProductDao pDao;
	
	 @Override
	 public Cart addProductToCart(Cart cart, String customerid, Integer prodId, Integer quantity) throws CustomerException,CartException,ProductException {
	 	Product product = pDao.findById(prodId).orElseThrow(() -> new ProductException("No product found with product id: "+prodId));
	 	Customer customer = customerDao.findByCustomerId(customerid).orElseThrow(() -> new CustomerException("No customer exist with customer id: "+customerid));
	 	cart.setCustomer(customer);
	 	cart.getProductList().put(product, quantity);
	 	return cDao.save(cart);
	 }

	@Override
	public Cart removeProductFromCart(Integer cartId,Integer prodId) throws CartException,ProductException {
		Product product = pDao.findById(prodId).orElseThrow(() -> new ProductException("No product found with product id: "+prodId));
		Cart cart = cDao.findById(cartId).orElseThrow(() -> new CartException("No cart found with cart id: "+cartId));
		
		cart.getProductList().remove(product);
		
		return cDao.save(cart);
	}

	 @Override
	 public Cart updateProductQuantity(Integer cartId,Integer prodId, int quantity) throws CartException,ProductException {
	 	Product product = pDao.findById(prodId).orElseThrow(() -> new ProductException("No product found with product id: "+prodId));
	 	Cart cart = cDao.findById(cartId).orElseThrow(() -> new CartException("No cart found with cart id: "+cartId));
		
	 	cart.getProductList().replace(product, quantity);
		
	 	return cDao.save(cart);
	 }

	@Override
	public Cart removeAllProducts(Integer cartId) throws CartException {
		Cart cart = cDao.findById(cartId).orElseThrow(() -> new CartException("No cart found with cart id: "+cartId));
		cart.getProductList().clear();
		cDao.delete(cart);
		return cart;
	}

 	@Override
 	public List<Product> viewAllProducts(Integer cartId) throws CartException,ProductException {
 		Cart cart = cDao.findById(cartId).orElseThrow(() -> new CartException("No cart found with cart id: "+cartId));
 		List<Product> products = new ArrayList<>();
		
 		 for(Map.Entry m : cart.getProductList().entrySet()){    
 			 System.out.println(m.getKey()+" "+m.getValue());
 			 products.add((Product) m.getKey());
 		 }
		 
 		 if(products.size()==0) {
 			 throw new ProductException("No product exist in this cart");
 		 }
		 
 		 return products;
 	}

	
	
}

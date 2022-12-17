package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ProductException;
import com.masai.module.Product;
import com.masai.repository.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao pDao;
	
	@Override
	public List<Product> viewAllProducts() throws ProductException {
		
		    List<Product> list= pDao.findAll();
		    
		    if(list.size()==0) {
		       throw new ProductException("Product DataBase is EMPTY!!!!");
		    }
		
		return list;
	}

	@Override
	public Product addProduct(Product product) throws ProductException {
		
		if(product!=null){
			return pDao.save(product);

		}
		
		throw new ProductException("invalid data...");
	}

	@Override
	public Product updateProduct(Product product) throws ProductException {
		
		Optional<Product> opt=pDao.findById(product.getProductId());
		
		if(opt.isPresent()) {
			
			pDao.save(product);
			
			return product;
			
		}
		
		throw new ProductException("Product not found....!!!!!!!!");
	}

	@Override
	public Product viewProduct(Integer pId) throws ProductException {
		Optional<Product> opt=pDao.findById(pId);
		
		if(opt.isPresent()) {
			Product product=opt.get();
			
			return product;
		}
		
		throw new ProductException("Product not found....!!!!!!!!");
	}

	@Override
	public List<Product> viewAllProductsByCategory(String cname) throws ProductException {
		
		List<Product> list=pDao.findAllByCategory(cname);
		
		if(list.size()==0) {
			throw new ProductException("Product not found....!!!!!!!!");
		}
		
		return list;
	}

	@Override
	public Product removeProduct(Integer pId) throws ProductException {
		
         Optional<Product> opt=pDao.findById(pId);
		
		if(opt.isPresent()) {
			Product pro=opt.get();
			pDao.delete(pro);
			
			return pro;
		}
		
		throw new ProductException("Product not found....!!!!!!!!");
	}

}

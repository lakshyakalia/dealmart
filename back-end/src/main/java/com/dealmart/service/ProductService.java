package com.dealmart.service;

import java.util.List;

import com.dealmart.model.Product;


public interface ProductService {

	Product createProduct(Product product);
	
	List<Product> getAllProducts();
	
	Product getProductById(long id);
	
	Product updateProduct(Product product, long id);
	
	void deleteProduct(long id);
}

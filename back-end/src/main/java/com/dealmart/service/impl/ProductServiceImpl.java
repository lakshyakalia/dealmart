package com.dealmart.service.impl;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dealmart.exception.ResourceNotFoundException;
import com.dealmart.model.Product;
import com.dealmart.repository.ProductRepository;
import com.dealmart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	

	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts(String category, int offset, int limit) {
		Pageable pageable = PageRequest.of(offset, limit);

		if(category == null || category.isEmpty()){
			return productRepository.findAll(pageable).getContent();
		}
		else{
			return productRepository.findByCategory(category, pageable);
		}
	}

	@Override
	public Product getProductById(long id) {
		return productRepository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Product", "Id", id));
	}

	@Override
	public Product updateProduct(Product product, long id) {
		Product existingProduct = productRepository.findById(id).orElseThrow(() ->
			new ResourceNotFoundException("Product", "Id", id));
	
		existingProduct.setPrice(product.getPrice());
		existingProduct.setProductCategory(product.getProductCategory());
		existingProduct.setProductDescription(product.getProductDescription());
		existingProduct.setProductName(product.getProductName());
		existingProduct.setSeller(product.getSeller());
		existingProduct.setTotalQuantity(product.getTotalQuantity());
		existingProduct.setImage(product.getImage());
		
		productRepository.save(existingProduct);
		
		return existingProduct;
	}

	@Override
	public void deleteProduct(long id) {
		productRepository.findById(id).orElseThrow(() ->
			new ResourceNotFoundException("Product", "Id", id));
		productRepository.deleteById(id);
		
	}

}

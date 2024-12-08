package com.dealmart.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dealmart.model.Product;
import com.dealmart.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@PostMapping()
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(productService.createProduct(product), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long productId){
		return new ResponseEntity<Product>(productService.getProductById(productId), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") long productId, @RequestBody Product product){
		return new ResponseEntity<Product>(productService.updateProduct(product, productId), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") long productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<String>("Product Deleted Successfully!", HttpStatus.OK);
	}

}

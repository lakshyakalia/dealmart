package com.dealmart.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dealmart.model.Product;
import com.dealmart.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
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
	public List<Product> getAllProducts(@RequestParam(value = "category", required = false) String category, @RequestParam("offset") int offset, @RequestParam("limit") int limit){
		return productService.getAllProducts(category, offset, limit);
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

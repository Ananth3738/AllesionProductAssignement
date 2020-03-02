package com.allesion.products.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allesion.products.entity.Product;
import com.allesion.products.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductResource {

	private final ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> findAllProducts(){
		return ResponseEntity.ok(productService.findAllProducts());
	}

	@PostMapping
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product){
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findProductById(@PathVariable(value="id") Long id){
		Optional<Product> product = productService.findProductById(id);
		if(product.isPresent()){
			return ResponseEntity.ok(product.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found for id : "+id);
	}

	@PutMapping
	public ResponseEntity<Object> updateProduct(@PathVariable(value="id") Long id,@Valid @RequestBody Product productDts){
		Optional<Product> product = productService.findProductById(id);
		if(product.isPresent()){
			Product product2 = product.get();
			product2.setName(productDts.getName());
			product2.setCurrentPrice(productDts.getCurrentPrice());
			product2.setLastUpdated(productDts.getLastUpdated());
			return ResponseEntity.ok(productService.saveProduct(product2));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found for id : "+id);
	}
}

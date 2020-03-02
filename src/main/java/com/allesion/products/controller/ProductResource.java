package com.allesion.products.controller;

import java.util.List;

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
import com.allesion.products.exception.ProductNotFoundException;
import com.allesion.products.service.ProductService;

import lombok.RequiredArgsConstructor;


/**
 * Instantiates a new product resource.
 *
 * @param productService the product service
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductResource {

	/** The product service. */
	private final ProductService productService;

	/**
	 * Find all products.
	 *
	 * @return the response entity
	 */
	@GetMapping
	public ResponseEntity<List<Product>> findAllProducts(){
		return ResponseEntity.ok(productService.findAllProducts());
	}

	/**
	 * Adds the product.
	 *
	 * @param product the product
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product){
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
	}

	/**
	 * Find product by id.
	 *
	 * @param id the id
	 * @return the response entity
	 * @throws ProductNotFoundException the product not found exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Product> findProductById(@PathVariable(value="id") Long id) throws ProductNotFoundException{
		Product product = productService.findProductById(id).orElseThrow(()-> new ProductNotFoundException("Product not found for id :"+id));
		return ResponseEntity.ok(product);
	}

	/**
	 * Update product.
	 *
	 * @param id the id
	 * @param productDts the product dts
	 * @return the response entity
	 * @throws ProductNotFoundException the product not found exception
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value="id") Long id,@Valid @RequestBody Product productDts) throws ProductNotFoundException{
		Product product = productService.findProductById(id).orElseThrow(()-> new ProductNotFoundException("Product not found for id :"+id));;
		product.setName(productDts.getName());
		product.setCurrentPrice(productDts.getCurrentPrice());
		product.setLastUpdated(productDts.getLastUpdated());
		return ResponseEntity.ok(productService.saveProduct(product));
	}
}

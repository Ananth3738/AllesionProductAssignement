package com.allesion.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.allesion.products.entity.Product;
import com.allesion.products.reporsitory.ProductRepository;

import lombok.RequiredArgsConstructor;


/**
 * Instantiates a new product service.
 *
 * @param productResository the product resository
 */
@RequiredArgsConstructor
@Service
public class ProductService {

	/** The product resository. */
	private final ProductRepository productResository;
	
	/**
	 * Find all products.
	 *
	 * @return the list
	 */
	public List<Product> findAllProducts(){
		return productResository.findAll();
	}
	
	/**
	 * Find product by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	public Optional<Product> findProductById(Long id){
		return productResository.findById(id);
	}
	
	/**
	 * Save product.
	 *
	 * @param product the product
	 * @return the product
	 */
	public Product saveProduct(Product product){
		return productResository.save(product);
	}
}

package com.allesion.products.service;

import java.util.List;
import java.util.Optional;

import com.allesion.products.entity.Product;
import com.allesion.products.reporsitory.ProductResository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductService {

	private final ProductResository productResository;
	
	public List<Product> findAllProducts(){
		return productResository.findAll();
	}
	
	public Optional<Product> findProductById(Long id){
		return productResository.findById(id);
	}
	
	public Product saveProduct(Product product){
		return productResository.save(product);
	}
}

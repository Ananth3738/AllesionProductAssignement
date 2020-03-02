package com.allesion.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.allesion.products.entity.Product;
import com.allesion.products.reporsitory.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

	private final ProductRepository productResository;
	
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

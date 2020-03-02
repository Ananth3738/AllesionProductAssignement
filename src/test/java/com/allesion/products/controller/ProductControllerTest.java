package com.allesion.products.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.allesion.products.entity.Product;
import com.allesion.products.exception.ProductNotFoundException;
import com.allesion.products.service.ProductService;

public class ProductControllerTest {
	
	@InjectMocks
	ProductResource resource;

	@Mock
	ProductService productService;

	@BeforeEach
	public  void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindAll(){
		Product prd1 = new Product("Product1", BigDecimal.valueOf(1000), java.util.Date.from(Instant.now()));
		Product prd2 = new Product("Product2", BigDecimal.valueOf(1000), java.util.Date.from(Instant.now()));

		List<Product> allProducts = Arrays.asList(prd1,prd2);

		when(productService.findAllProducts()).thenReturn(allProducts);

		List<Product> result = productService.findAllProducts();

		assertEquals(result.size(),2);

		assertEquals(result.get(0).getName(),"Product1");

		assertEquals(result.get(1).getName(),"Product2");
	}

	@Test
	public void testAddProduct(){
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Product product = new Product("Product1", BigDecimal.valueOf(1000), java.util.Date.from(Instant.now()));
		
		
		when(productService.saveProduct(any(Product.class))).thenReturn(product);

		ResponseEntity<Product> responseEntity = resource.addProduct(product);

		assertEquals(responseEntity.getStatusCodeValue(),201);
	}
	
	@Test
	public void testGetById() throws ProductNotFoundException{
		Product product1 = new Product("Product1", BigDecimal.valueOf(1000), java.util.Date.from(Instant.now()));

		Optional<Product> prodOps = Optional.of(product1);
		when(productService.findProductById(1L)).thenReturn(prodOps);
		
		ResponseEntity<Product> responseEntity = resource.findProductById(1L);

		assertEquals(responseEntity.getStatusCodeValue(),200);
		
		assertEquals(responseEntity.getBody().getName(),product1.getName());
	}
	
	
	@Test
	public void testProductNotFound() throws ProductNotFoundException{
		assertThrows(ProductNotFoundException.class, ()->{
			resource.findProductById(6565656L);
		});
	}
}

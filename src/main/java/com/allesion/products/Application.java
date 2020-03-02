package com.allesion.products;

import java.math.BigDecimal;
import java.time.Instant;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.allesion.products.entity.Product;
import com.allesion.products.reporsitory.ProductRepository;

@SpringBootApplication
public class Application {

	@Autowired
	private ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	InitializingBean loadInitialData() {
		return () -> {
			productRepository.save(new Product("Product1", BigDecimal.valueOf(1000), java.util.Date.from(Instant.now())));
			productRepository.save(new Product("Product2", BigDecimal.valueOf(2000), java.util.Date.from(Instant.now())));
			productRepository.save(new Product("Product3", BigDecimal.valueOf(3000), java.util.Date.from(Instant.now())));
		};
	}
	
}

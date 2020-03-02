package com.allesion.products.config;

import java.math.BigDecimal;
import java.time.Instant;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.allesion.products.entity.Product;
import com.allesion.products.reporsitory.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class InMemoryProducts {
	
	private ProductRepository productRepository;

	@Bean
	InitializingBean loadInitialData() {
		return () -> {
			productRepository.save(new Product("Product1", BigDecimal.valueOf(1000), java.util.Date.from(Instant.now())));
			productRepository.save(new Product("Product2", BigDecimal.valueOf(2000), java.util.Date.from(Instant.now())));
			productRepository.save(new Product("Product3", BigDecimal.valueOf(3000), java.util.Date.from(Instant.now())));
		};
	}
}

package com.allesion.products.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allesion.products.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}

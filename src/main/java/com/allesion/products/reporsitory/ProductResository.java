package com.allesion.products.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allesion.products.entity.Product;

public interface ProductResository extends JpaRepository<Product, Long>{

}

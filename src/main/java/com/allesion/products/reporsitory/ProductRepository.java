package com.allesion.products.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.allesion.products.entity.Product;

/**
 * The Interface ProductRepository.
 */
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long>{

}

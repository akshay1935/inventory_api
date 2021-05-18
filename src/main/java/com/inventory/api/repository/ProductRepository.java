package com.inventory.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.inventory.api.entity.Product;

public interface ProductRepository extends CrudRepository<Product, String> {
	Iterable<Product> findAllByStatus(String status);
	
	Long countByStockStatus(String status);
}

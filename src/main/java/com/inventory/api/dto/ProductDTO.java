package com.inventory.api.dto;

import java.sql.Timestamp;

import org.dozer.DozerBeanMapper;

import com.inventory.api.entity.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
	private String productId;
	private String name;
	private String description;
	private String price;
	private String stockStatus;
	private String status;
	Timestamp createdAt;
	Timestamp updatedAt;

	// Converts Entity into DTO
	public static ProductDTO valueOf(Product product) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		return mapper.map(product, ProductDTO.class);

	}

	// Converts DTO into Entity
	public Product createEntity() {
		DozerBeanMapper mapper = new DozerBeanMapper();
		return mapper.map(this, Product.class);
	}
}

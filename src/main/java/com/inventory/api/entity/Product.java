package com.inventory.api.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
	@Id
	@Column(length = 64)
	private String productId;
	private String name;
	private String description;
	private String price;
	private String stockStatus;
	private String status;
	Timestamp createdAt;
	Timestamp updatedAt;
}

package com.inventory.api.service;

import java.util.List;

import com.inventory.api.dto.DashboardDTO;
import com.inventory.api.dto.ProductDTO;

public interface ProductService {

	public ProductDTO addProduct(ProductDTO productDTO);

	public ProductDTO updateProduct(ProductDTO productDTO);

	public ProductDTO getProduct(String productID);

	public List<ProductDTO> getAllProducts();
	
	public DashboardDTO getDashboard(); 
	
}

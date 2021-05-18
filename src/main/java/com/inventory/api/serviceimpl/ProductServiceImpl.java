package com.inventory.api.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.api.dto.DashboardDTO;
import com.inventory.api.dto.ProductDTO;
import com.inventory.api.entity.Product;
import com.inventory.api.exception.ProductNotFoundException;
import com.inventory.api.repository.ProductRepository;
import com.inventory.api.service.ProductService;
import com.inventory.api.utility.AppUtil;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public ProductDTO addProduct(ProductDTO productDTO) {
		productDTO.setCreatedAt(AppUtil.getCurrentSystemDate());
		productDTO.setUpdatedAt(AppUtil.getCurrentSystemDate());
		productDTO.setProductId(AppUtil.generateUniqueId());

		return ProductDTO.valueOf(productRepository.save(productDTO.createEntity()));
	}

	@Override
	public ProductDTO updateProduct(ProductDTO productDTO) {
		ProductDTO updatedProductDTO = null;

		Optional<Product> product = productRepository.findById(productDTO.getProductId());
		if (product.isPresent()) {
			updatedProductDTO = ProductDTO.valueOf(product.get());

			updatedProductDTO.setName(productDTO.getName());
			updatedProductDTO.setPrice(productDTO.getPrice());
			updatedProductDTO.setStatus(productDTO.getStatus());
			updatedProductDTO.setStockStatus(productDTO.getStockStatus());
			updatedProductDTO.setDescription(productDTO.getDescription());
			updatedProductDTO.setUpdatedAt(AppUtil.getCurrentSystemDate());

			productRepository.save(updatedProductDTO.createEntity());
		} else {
			throw new ProductNotFoundException("Product not found");
		}

		return productDTO;
	}

	@Override
	public ProductDTO getProduct(String productID) {
		ProductDTO productDTO = null;

		Optional<Product> product = productRepository.findById(productID);
		if (product.isPresent()) {
			productDTO = ProductDTO.valueOf(product.get());

		} else {
			throw new ProductNotFoundException("Product not found");
		}

		return productDTO;
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		Iterable<Product> products = productRepository.findAllByStatus("ACTIVE");
		List<ProductDTO> productDtos = new ArrayList<>();

		for (Product product : products) {
			productDtos.add(ProductDTO.valueOf(product));
		}

		if (productDtos.size() < 1) {
			throw new ProductNotFoundException("Product not found");
		}
		return productDtos;
	}

	@Override
	public DashboardDTO getDashboard() {
		long availableCount = productRepository.countByStockStatus("AVAILABLE");
		long emptyCount = productRepository.countByStockStatus("EMPTY");
		long productCount = availableCount + emptyCount;
		DashboardDTO dashboardDTO = new DashboardDTO();
		dashboardDTO.setProductCount(productCount);
		dashboardDTO.setAvailableCount(availableCount);
		dashboardDTO.setEmptyCount(emptyCount);

		return dashboardDTO;
	}

}

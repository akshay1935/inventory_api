package com.inventory.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.api.dto.DashboardDTO;
import com.inventory.api.dto.ProductDTO;
import com.inventory.api.service.ProductService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productService;

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductDTO addProduct(@Valid @RequestBody ProductDTO productDTO,
			@RequestHeader("Authorization") String token) {
		return productService.addProduct(productDTO);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductDTO updateProduct(@Valid @RequestBody ProductDTO productDTO,
			@RequestHeader("Authorization") String token) {
		return productService.updateProduct(productDTO);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping(value = "/{productID}")
	public ProductDTO getProduct(@Valid @PathVariable String productID, @RequestHeader("Authorization") String token) {
		return productService.getProduct(productID);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping
	public List<ProductDTO> getAllProduct(@RequestHeader("Authorization") String token) {
		return productService.getAllProducts();
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping(value = "/dashboard")
	public DashboardDTO getDashboard(@RequestHeader("Authorization") String token) {
		return productService.getDashboard();
	}
}

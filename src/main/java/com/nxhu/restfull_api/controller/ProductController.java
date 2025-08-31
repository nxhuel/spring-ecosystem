package com.nxhu.restfull_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nxhu.restfull_api.dto.ProductDTO;
import com.nxhu.restfull_api.persistence.entity.ProductEntity;
import com.nxhu.restfull_api.service.IProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

	private final IProductService productService;
	
	@GetMapping
	public List<ProductEntity> findAllProducts() {
		return productService.findAllProducts();
	}	
	
	@GetMapping("/dto")
	public List<ProductDTO> findAllProductsDTO() {
		return productService.findAllProductsDTO();
	}	
}

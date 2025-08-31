package com.nxhu.restfull_api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nxhu.restfull_api.config.AuthMapper;
import com.nxhu.restfull_api.dto.ProductDTO;
import com.nxhu.restfull_api.persistence.entity.ProductEntity;
import com.nxhu.restfull_api.persistence.repository.IProductRepository;
import com.nxhu.restfull_api.service.IProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

	private final IProductRepository productRepository;

	@Override
	public List<ProductEntity> findAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public List<ProductDTO> findAllProductsDTO() {
		List<ProductDTO> products = productRepository.findAll().stream()
				.map(AuthMapper::toDto)
				.toList();
		
		return products;
	}

}

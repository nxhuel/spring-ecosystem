package com.nxhu.restfull_api.service;

import java.util.List;

import com.nxhu.restfull_api.dto.ProductDTO;
import com.nxhu.restfull_api.persistence.entity.ProductEntity;

public interface IProductService {

	List<ProductEntity> findAllProducts();
	
	List<ProductDTO> findAllProductsDTO();
}

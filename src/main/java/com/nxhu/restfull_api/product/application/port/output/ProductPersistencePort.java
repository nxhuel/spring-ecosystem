package com.nxhu.restfull_api.product.application.port.output;

import java.util.List;
import java.util.Optional;

import com.nxhu.restfull_api.product.domain.model.ProductModel;

public interface ProductPersistencePort {

	Optional<ProductModel> findById(Long id);
	
	List<ProductModel> findAll();
	
	ProductModel save(ProductModel productModel);
		
	void deleteById(Long id);
}

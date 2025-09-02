package com.nxhu.restfull_api.product.application.ports.input;

import java.util.List;

import com.nxhu.restfull_api.product.domain.exception.ProductNotFoundException;
import com.nxhu.restfull_api.product.domain.model.ProductModel;

// use case
public interface ProductServicePort {

	ProductModel findProductById(Long id) throws ProductNotFoundException ;
	
	List<ProductModel> findAllProducts();
	
	ProductModel saveProduct(ProductModel productModel);
	
	ProductModel updateProductById(Long id, ProductModel productModel) throws ProductNotFoundException ;
	
	void deleteProductById(Long id) throws ProductNotFoundException ;
}

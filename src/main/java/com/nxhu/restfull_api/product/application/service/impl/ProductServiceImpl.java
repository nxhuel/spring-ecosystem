package com.nxhu.restfull_api.product.application.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nxhu.restfull_api.product.application.ports.input.ProductServicePort;
import com.nxhu.restfull_api.product.application.ports.output.ProductPersistencePort;
import com.nxhu.restfull_api.product.domain.exception.ProductNotFoundException;
import com.nxhu.restfull_api.product.domain.model.ProductModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductServicePort {

	private final ProductPersistencePort productPersistencePort;

	@Override
	public ProductModel findProductById(Long id) throws ProductNotFoundException {
		return productPersistencePort.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));
	}

	@Override
	public List<ProductModel> findAllProducts() {
		return productPersistencePort.findAll();
	}

	@Override
	public ProductModel saveProduct(ProductModel productModel) {
		return productPersistencePort.save(productModel);
	}

	@Override
	public ProductModel updateProductById(Long id, ProductModel productModel) throws ProductNotFoundException {
		return productPersistencePort.findById(id).map(savedProduct -> {
			savedProduct.setName(productModel.getName());
			savedProduct.setPrice(productModel.getPrice());
			return productPersistencePort.save(savedProduct);
		}).orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));
	}

	@Override
	public void deleteProductById(Long id) throws ProductNotFoundException {
		if (productPersistencePort.findById(id).isEmpty()) {
			throw new ProductNotFoundException("Product with ID " + id + " not found");
		}

		productPersistencePort.deleteById(id);
	}

}

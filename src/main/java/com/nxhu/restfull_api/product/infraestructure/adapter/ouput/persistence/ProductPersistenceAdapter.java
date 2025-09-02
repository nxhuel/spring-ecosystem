package com.nxhu.restfull_api.product.infraestructure.adapter.ouput.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.nxhu.restfull_api.product.application.port.output.ProductPersistencePort;
import com.nxhu.restfull_api.product.domain.model.ProductModel;
import com.nxhu.restfull_api.product.infraestructure.adapter.ouput.persistence.mapper.ProductPersistenceMapper;
import com.nxhu.restfull_api.product.infraestructure.adapter.ouput.persistence.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductPersistencePort {

	private final ProductRepository productRepository;
	private final ProductPersistenceMapper productPersistenceMapper;

	@Override
	public Optional<ProductModel> findById(Long id) {
		return productRepository.findById(id).map(productPersistenceMapper::toProductModel);
	}

	@Override
	public List<ProductModel> findAll() {
		return productPersistenceMapper.toProductModels(productRepository.findAll());
	}

	@Override
	public ProductModel save(ProductModel productModel) {
		return productPersistenceMapper
				.toProductModel(productRepository.save(productPersistenceMapper.toProductEntity(productModel)));
	}

	@Override
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}

}

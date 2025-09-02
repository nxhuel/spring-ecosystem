package com.nxhu.restfull_api.product.infrastructure.adapters.input.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nxhu.restfull_api.product.application.ports.input.ProductServicePort;
import com.nxhu.restfull_api.product.domain.exception.ProductNotFoundException;
import com.nxhu.restfull_api.product.domain.model.ProductModel;
import com.nxhu.restfull_api.product.infrastructure.adapters.input.rest.mapper.ProductRestMapper;
import com.nxhu.restfull_api.product.infrastructure.adapters.input.rest.model.request.ProductCreateRequest;
import com.nxhu.restfull_api.product.infrastructure.adapters.input.rest.model.response.ProductResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductRestAdapter {

	private final ProductServicePort productServicePort;
	private final ProductRestMapper productRestMapper;
	
	@GetMapping("/v1/api")
	public ResponseEntity<List<ProductResponse>> findAllProducts() {
		List<ProductResponse> productsResponse = productRestMapper.toProductsResponse(productServicePort.findAllProducts());
		return new ResponseEntity<>(productsResponse, HttpStatus.OK);
	}
	
	@GetMapping("/v1/api/{id}")
	public ResponseEntity<ProductResponse> findProductById(@PathVariable Long id) throws ProductNotFoundException {
		ProductResponse productResponse = productRestMapper.toProductResponse(productServicePort.findProductById(id));
		return new ResponseEntity<>(productResponse, HttpStatus.OK);
	}
	
	@PostMapping("/v1/api")
	public ResponseEntity<ProductResponse> saveProduct(@Valid @RequestBody ProductCreateRequest productCreateRequest) {
		ProductModel productModel = productRestMapper.toProductModel(productCreateRequest);
		ProductResponse productResponse = productRestMapper.toProductResponse(productModel);
		return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
	}
	
	@PutMapping("/v1/api/{id}")
	public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductCreateRequest productCreateRequest) throws ProductNotFoundException {
		ProductModel productModel = productServicePort.updateProductById(id, productRestMapper.toProductModel(productCreateRequest));
		ProductResponse productResponse = productRestMapper.toProductResponse(productModel);
		
		return new ResponseEntity<>(productResponse, HttpStatus.OK);
	}
	
	@DeleteMapping("/v1/api/{id}")
	public ResponseEntity<Void> deleteProductById(@PathVariable Long id) throws ProductNotFoundException {
		productServicePort.deleteProductById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
	}
}

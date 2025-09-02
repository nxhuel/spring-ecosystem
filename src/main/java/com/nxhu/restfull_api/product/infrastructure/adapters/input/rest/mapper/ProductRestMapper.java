package com.nxhu.restfull_api.product.infrastructure.adapters.input.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.nxhu.restfull_api.product.domain.model.ProductModel;
import com.nxhu.restfull_api.product.infrastructure.adapters.input.rest.model.request.ProductCreateRequest;
import com.nxhu.restfull_api.product.infrastructure.adapters.input.rest.model.response.ProductResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductRestMapper {

	ProductModel toProductModel(ProductCreateRequest productCreateRequest);

	ProductResponse toProductResponse(ProductModel productModel);

	List<ProductResponse> toProductsResponse(List<ProductModel> productsModel);

}

package com.nxhu.restfull_api.product.infraestructure.adapter.ouput.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.nxhu.restfull_api.product.domain.model.ProductModel;
import com.nxhu.restfull_api.product.infraestructure.adapter.ouput.persistence.entity.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductPersistenceMapper {

	ProductEntity toProductEntity(ProductModel productModel);
	
	ProductModel toProductModel(ProductEntity productEntity);
	
	List<ProductModel> toProductModels(List<ProductEntity> productEntities);

}

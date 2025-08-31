package com.nxhu.restfull_api.config;

import com.nxhu.restfull_api.dto.LocalDTO;
import com.nxhu.restfull_api.dto.ProductDTO;
import com.nxhu.restfull_api.persistence.entity.LocalEntity;
import com.nxhu.restfull_api.persistence.entity.ProductEntity;

public class AuthMapper {
	
	public static LocalDTO toDto(final LocalEntity localEntity) {
		return new LocalDTO(
				localEntity.getName(),
				localEntity.getFloor()
				);
	}

	public static ProductDTO toDto(final ProductEntity productEntity) {
		return new ProductDTO(
				productEntity.getName(),
				productEntity.getBrand(),
				toDto(productEntity.getLocal())
				);
	}
}

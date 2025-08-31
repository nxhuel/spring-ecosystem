package com.nxhu.restfull_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {
	private String name;
	private String brand;
	private LocalDTO local;
}

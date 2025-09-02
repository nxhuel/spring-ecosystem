package com.nxhu.restfull_api.product.infraestructure.adapter.input.rest.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateRequest {

	@NotBlank(message = "Product name must not be empty or null")
	private String name;

	@NotNull(message = "Product price must not be null")
	@Min(value = 10, message = "The price of the product must be greater than 10")
	private float price;
}

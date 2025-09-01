package com.nxhu.restfull_api.Local.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
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
public class LocalCreateRequest {
	
	@NotBlank(message = "Local name must not be empty or null")
	private String name;

	@NotBlank(message = "Local floor must not be empty or null")
	private String floor;
}

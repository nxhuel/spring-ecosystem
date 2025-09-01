package com.nxhu.restfull_api.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterRequestDTO(
		@NotBlank
		String firstName,
		
		@NotBlank
		String lastName,
		
		@Email
		@NotBlank
		String email,
		
		String password
		) {

}

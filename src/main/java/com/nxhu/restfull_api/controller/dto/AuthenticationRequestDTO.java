package com.nxhu.restfull_api.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationRequestDTO(
		@Email
		@NotBlank
		String email,
		
		@NotBlank
		String password
		) {

}

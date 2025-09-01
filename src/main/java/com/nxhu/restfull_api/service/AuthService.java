package com.nxhu.restfull_api.service;

import com.nxhu.restfull_api.controller.dto.AuthResponseDTO;
import com.nxhu.restfull_api.controller.dto.AuthenticationRequestDTO;
import com.nxhu.restfull_api.controller.dto.RegisterRequestDTO;

public interface AuthService {
	
	AuthResponseDTO register(RegisterRequestDTO registerRequest);
	
	AuthResponseDTO authenticate(AuthenticationRequestDTO authenticationRequest);

	void logout();

}
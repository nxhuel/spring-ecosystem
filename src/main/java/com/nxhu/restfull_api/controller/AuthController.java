package com.nxhu.restfull_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nxhu.restfull_api.controller.dto.AuthResponseDTO;
import com.nxhu.restfull_api.controller.dto.AuthenticationRequestDTO;
import com.nxhu.restfull_api.controller.dto.RegisterRequestDTO;
import com.nxhu.restfull_api.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<AuthResponseDTO> register(@RequestBody @Valid RegisterRequestDTO registerRequest) {
		return new ResponseEntity<>(authService.register(registerRequest), HttpStatus.CREATED);
	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthResponseDTO> authenticate(@RequestBody @Valid AuthenticationRequestDTO authenticationRequest) {
		return new ResponseEntity<>(authService.authenticate(authenticationRequest), HttpStatus.OK);
	}

	@PostMapping("/logout")
	public ResponseEntity<?> logout() {
		authService.logout();
		return ResponseEntity.ok().build();
	}

}
package com.nxhu.restfull_api.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.nxhu.restfull_api.config.JwtService;
import com.nxhu.restfull_api.config.SelfMapper;
import com.nxhu.restfull_api.controller.dto.AuthResponseDTO;
import com.nxhu.restfull_api.controller.dto.AuthenticationRequestDTO;
import com.nxhu.restfull_api.controller.dto.RegisterRequestDTO;
import com.nxhu.restfull_api.persistence.entity.UserEntity;
import com.nxhu.restfull_api.persistence.repository.UserRepository;
import com.nxhu.restfull_api.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
	
	private final UserRepository userRepository;
	private final SelfMapper selfMapper;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	
	@Override
	public AuthResponseDTO register(RegisterRequestDTO registerRequest) {
		UserEntity registerUser = selfMapper.registerFromDto(registerRequest);
		userRepository.save(registerUser);
		String jwtToken = jwtService.generateToken(registerUser);
		
        System.out.println("[USER] : User successfully registered with id {}" + registerUser.getId());
		
		return new AuthResponseDTO(jwtToken);
	}

	@Override
	public AuthResponseDTO authenticate(AuthenticationRequestDTO authenticationRequest) {
// 		verifica si las credenciales del usuario son válidas
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						authenticationRequest.email(), 
						authenticationRequest.password())
				);
		
//		trae al usuario nuevamente por seguridad y crea su token
		UserEntity user = userRepository.findByEmail(authenticationRequest.email()).orElseThrow();
		String jwtToken = jwtService.generateToken(user);
		
		return new AuthResponseDTO(jwtToken) ;
	}

	@Override
	public void logout() {
	}

}
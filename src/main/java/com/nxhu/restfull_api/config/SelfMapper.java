package com.nxhu.restfull_api.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.nxhu.restfull_api.controller.dto.RegisterRequestDTO;
import com.nxhu.restfull_api.persistence.entity.RoleEnum;
import com.nxhu.restfull_api.persistence.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SelfMapper {
	
	private final PasswordEncoder passwordEncoder;

	public UserEntity registerFromDto(final RegisterRequestDTO registerRequest) {
		return UserEntity.builder()
			.firstName(registerRequest.firstName())
			.lastName(registerRequest.lastName())
			.email(registerRequest.email())
			.password(passwordEncoder.encode(registerRequest.password()))
			.role(RoleEnum.USER)
			.build();
	}

}
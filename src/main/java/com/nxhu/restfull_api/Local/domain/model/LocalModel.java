package com.nxhu.restfull_api.local.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocalModel {

	private Long id;
	
	private String name;
	
	private String floor;
}

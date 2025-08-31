package com.nxhu.restfull_api.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "local")
public class LocalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_local")
	private Long idLocal;
	
	@Column(nullable = false, unique = true)
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	@Column(nullable = false, unique = true)
	@NotBlank(message = "Floor is mandatory")
	private String floor;

}

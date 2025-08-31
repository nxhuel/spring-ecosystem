package com.nxhu.restfull_api.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduct;
	
	private String name;
	
	private String brand;
	
	private boolean expired;
	
	private float price;
	
	@ManyToOne
	@JoinColumn(
			name = "id_local",
			referencedColumnName = "id_local"
			)
	private LocalEntity local;
}

package com.nxhu.restfull_api;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nxhu.restfull_api.Local.infrastructure.adapters.output.persistence.entity.LocalEntity;
import com.nxhu.restfull_api.Local.infrastructure.adapters.output.persistence.repository.LocalRepository;
import com.nxhu.restfull_api.product.infraestructure.adapter.ouput.persistence.entity.ProductEntity;
import com.nxhu.restfull_api.product.infraestructure.adapter.ouput.persistence.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class RestfullApiApplication implements CommandLineRunner {

	private final LocalRepository localRepository;
	private final ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestfullApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<LocalEntity> localEntities = Arrays.asList(new LocalEntity(null, "Local 1", "Piso 1"),
				new LocalEntity(null, "Local 2", "Piso 2"), new LocalEntity(null, "Local 3", "Piso 3"),
				new LocalEntity(null, "Local 4", "Piso 4"), new LocalEntity(null, "Local 5", "Piso 5"));

		localRepository.saveAll(localEntities);

		List<ProductEntity> productEntities = Arrays.asList(new ProductEntity(null, "product 1", 100),
				new ProductEntity(null, "product 2", 200), new ProductEntity(null, "product 3", 300),
				new ProductEntity(null, "product 4", 400), new ProductEntity(null, "product 5", 500));

		productRepository.saveAll(productEntities);
	}
}

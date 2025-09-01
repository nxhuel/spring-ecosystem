package com.nxhu.restfull_api;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nxhu.restfull_api.Local.infrastructure.adapters.output.persistence.entity.LocalEntity;
import com.nxhu.restfull_api.Local.infrastructure.adapters.output.persistence.repository.LocalRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class RestfullApiApplication implements CommandLineRunner {
	
	private final LocalRepository localRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestfullApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<LocalEntity> localEntities = Arrays.asList(
				new LocalEntity(null, "Local 1", "Piso 1"),
				new LocalEntity(null, "Local 2", "Piso 2"),
				new LocalEntity(null, "Local 3", "Piso 3"),
				new LocalEntity(null, "Local 4", "Piso 4"),
				new LocalEntity(null, "Local 5", "Piso 5")
				);
		
		localRepository.saveAll(localEntities);
	}
}

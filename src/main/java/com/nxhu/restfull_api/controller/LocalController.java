package com.nxhu.restfull_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nxhu.restfull_api.exception.LocalNotFoundException;
import com.nxhu.restfull_api.persistence.entity.LocalEntity;
import com.nxhu.restfull_api.service.ILocalService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/local")
@RequiredArgsConstructor
public class LocalController {

	private final ILocalService iLocalService;

	@GetMapping
	public List<LocalEntity> findAllLocals() {
		return iLocalService.findAllLocals();
	}

	@PostMapping
	public ResponseEntity<?> saveLocal(@Valid @RequestBody LocalEntity local) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(iLocalService.saveLocal(local));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el servidor: " + e);
		}
	}

	@PutMapping("/{id}")
	public LocalEntity updateLocal(@PathVariable Long id, @RequestBody LocalEntity local) throws LocalNotFoundException {
		return iLocalService.updateLocal(id, local);
	}

	@DeleteMapping("/{id}")
	public String deleteLocal(@PathVariable Long id) throws LocalNotFoundException {
		iLocalService.deleteLocal(id);
		return "Succesfully deleted";
	}

	@GetMapping("/name/{name}")
	public Optional<LocalEntity> findByNameIgnoreCase(@PathVariable String name) {
		return iLocalService.findByNameIgnoreCase(name);
	}

	@GetMapping("/{id}")
	public LocalEntity findLocalById(@PathVariable Long id) throws LocalNotFoundException{
		return iLocalService.findLocalById(id);
	}

}

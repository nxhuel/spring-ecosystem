package com.nxhu.restfull_api.local.infrastructure.adapters.input.rest;

import java.util.List;

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

import com.nxhu.restfull_api.local.application.ports.input.LocalServicePort;
import com.nxhu.restfull_api.local.domain.exception.LocalNotFoundException;
import com.nxhu.restfull_api.local.domain.model.LocalModel;
import com.nxhu.restfull_api.local.infrastructure.adapters.input.rest.mapper.LocalRestMapper;
import com.nxhu.restfull_api.local.infrastructure.adapters.input.rest.model.request.LocalCreateRequest;
import com.nxhu.restfull_api.local.infrastructure.adapters.input.rest.model.response.LocalResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/local")
@RequiredArgsConstructor
public class LocalRestAdapter {

	private final LocalServicePort localServicePort;
	private final LocalRestMapper localRestMapper;

	@GetMapping("/v1/api")
	public ResponseEntity<List<LocalResponse>> findAllLocal() {
		List<LocalResponse> localListResponse = localRestMapper.toLocalResponseList(localServicePort.findAll());
		return new ResponseEntity<>(localListResponse, HttpStatus.OK);
	}

	@GetMapping("/v1/api/{id}")
	public ResponseEntity<LocalResponse> findLocalById(@PathVariable Long id) throws LocalNotFoundException {
		LocalResponse localResponse = localRestMapper.toLocalResponse(localServicePort.findById(id));
		return new ResponseEntity<>(localResponse, HttpStatus.OK);
	}

	@PostMapping("/v1/api")
	public ResponseEntity<LocalResponse> saveLocal(@Valid @RequestBody LocalCreateRequest localCreateRequest) {
		LocalModel saveLocalModel = localServicePort.saveLocal(localRestMapper.toLocalModel(localCreateRequest));
		LocalResponse saveLocalResponse = localRestMapper.toLocalResponse(saveLocalModel);
		return new ResponseEntity<>(saveLocalResponse, HttpStatus.CREATED);
	}
	
	@PutMapping("/v1/api/{id}")
	public ResponseEntity<LocalResponse> updateLocalById(@PathVariable Long id, @Valid @RequestBody LocalCreateRequest localCreateRequest) throws LocalNotFoundException{
		LocalModel updateLocalModel = localServicePort.updateLocalById(id, localRestMapper.toLocalModel(localCreateRequest));
		LocalResponse updateLocalResponse = localRestMapper.toLocalResponse(updateLocalModel);
		return new ResponseEntity<>(updateLocalResponse, HttpStatus.OK);
	}
	
	@DeleteMapping("/v1/api/{id}")
	public ResponseEntity<Void> deleteLocalById(@PathVariable Long id) throws LocalNotFoundException {
		localServicePort.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

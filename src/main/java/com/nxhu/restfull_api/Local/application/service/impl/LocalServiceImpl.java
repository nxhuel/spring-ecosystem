package com.nxhu.restfull_api.local.application.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nxhu.restfull_api.local.application.ports.input.LocalServicePort;
import com.nxhu.restfull_api.local.application.ports.output.LocalPersistencePort;
import com.nxhu.restfull_api.local.domain.exception.LocalNotFoundException;
import com.nxhu.restfull_api.local.domain.model.LocalModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocalServiceImpl implements LocalServicePort {
	
	private final LocalPersistencePort localPersistencePort;

	@Override
	public LocalModel findById(Long id) throws LocalNotFoundException {
		return localPersistencePort.findById(id)
				.orElseThrow(() -> new LocalNotFoundException("Local with ID " + id + " not found"));
	}

	@Override
	public List<LocalModel> findAll() {
		return localPersistencePort.findAll();
	}

	@Override
	public LocalModel saveLocal(LocalModel localModel) {
		return localPersistencePort.save(localModel);
	}

	@Override
	public LocalModel updateLocalById(Long id, LocalModel localModel) throws LocalNotFoundException {		
		return localPersistencePort.findById(id)
				.map(savedProduct -> {
					savedProduct.setName(localModel.getName());
					savedProduct.setFloor(localModel.getFloor());
					return localPersistencePort.save(savedProduct);
				})
				.orElseThrow(() -> new LocalNotFoundException("Local with ID " + id + " not found"));
	}

	@Override
	public void deleteById(Long id) throws LocalNotFoundException {
		if (localPersistencePort.findById(id).isEmpty()) {
			throw new LocalNotFoundException("Local with ID " + id + " not found");
		}
		localPersistencePort.deleteById(id);
	}

}

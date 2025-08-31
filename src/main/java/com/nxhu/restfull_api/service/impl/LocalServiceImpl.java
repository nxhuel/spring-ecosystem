package com.nxhu.restfull_api.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nxhu.restfull_api.exception.LocalNotFoundException;
import com.nxhu.restfull_api.persistence.entity.LocalEntity;
import com.nxhu.restfull_api.persistence.repository.ILocalRepository;
import com.nxhu.restfull_api.service.ILocalService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocalServiceImpl implements ILocalService {
	
	private final ILocalRepository localRepository;

	@Override
	public List<LocalEntity> findAllLocals() {
		return localRepository.findAll();
	}

	@Override
	public LocalEntity saveLocal(LocalEntity local) {
		return localRepository.save(local);
	}

	@Override
	public LocalEntity updateLocal(Long id, LocalEntity local) throws LocalNotFoundException {
		LocalEntity localDb = localRepository.findById(id).orElseThrow(() -> new LocalNotFoundException("Local con id: " + id + " no encontrado"));
		
		if (Objects.nonNull(local.getName()) && !"".equalsIgnoreCase(local.getName())) {
			localDb.setName(local.getName());
		}
		
		if (Objects.nonNull(local.getFloor()) && !"".equalsIgnoreCase(local.getFloor())) {
			localDb.setFloor(local.getFloor());
		}
		
	
		return localRepository.save(localDb);
	}

	@Override
	public void deleteLocal(Long id) throws LocalNotFoundException {
		Optional<LocalEntity> localFound = localRepository.findById(id);
		if (!localFound.isPresent()) {
			throw new LocalNotFoundException("Local con id " + id + " no encontrado");
		}
		
		localRepository.deleteById(id);
	}
	
	@Override
	public Optional<LocalEntity> findByNameIgnoreCase(String name) {
		return localRepository.findByNameIgnoreCase(name);
	}

	@Override
	public LocalEntity findLocalById(Long id) throws LocalNotFoundException {
		return localRepository.findById(id).orElseThrow(() -> new LocalNotFoundException("Local con id " + id + " no encontrado"));
	}
}

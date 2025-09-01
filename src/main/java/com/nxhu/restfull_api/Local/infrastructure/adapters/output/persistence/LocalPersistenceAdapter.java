package com.nxhu.restfull_api.Local.infrastructure.adapters.output.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.nxhu.restfull_api.Local.application.ports.output.LocalPersistencePort;
import com.nxhu.restfull_api.Local.domain.model.LocalModel;
import com.nxhu.restfull_api.Local.infrastructure.adapters.output.persistence.mapper.LocalPersistenceMapper;
import com.nxhu.restfull_api.Local.infrastructure.adapters.output.persistence.repository.LocalRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LocalPersistenceAdapter implements LocalPersistencePort {

	private final LocalRepository localRepository;
	private final LocalPersistenceMapper localPersistenceMapper;

	@Override
	public Optional<LocalModel> findById(Long id) {
		return localRepository.findById(id).map(localPersistenceMapper::toLocalModel);
	}

	@Override
	public List<LocalModel> findAll() {
		return localPersistenceMapper.toLocalList(localRepository.findAll());
	}

	@Override
	public LocalModel save(LocalModel localModel) {
		return localPersistenceMapper
				.toLocalModel(localRepository.save(localPersistenceMapper.toLocalEntity(localModel)));
	}

	@Override
	public void deleteById(Long id) {
		localRepository.deleteById(id);
	}

}

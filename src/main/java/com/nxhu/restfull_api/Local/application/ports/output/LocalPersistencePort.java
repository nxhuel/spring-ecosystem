package com.nxhu.restfull_api.local.application.ports.output;

import java.util.List;
import java.util.Optional;

import com.nxhu.restfull_api.local.domain.model.LocalModel;

// operaciones necesarias para persistir
public interface LocalPersistencePort {

	Optional<LocalModel> findById(Long id);
	
	List<LocalModel> findAll();
	
	LocalModel save(LocalModel localModel);
		
	void deleteById(Long id);
	
}

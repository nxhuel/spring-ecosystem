package com.nxhu.restfull_api.Local.application.ports.input;

import java.util.List;

import com.nxhu.restfull_api.Local.domain.exception.LocalNotFoundException;
import com.nxhu.restfull_api.Local.domain.model.LocalModel;

// casos de uso de Local
public interface LocalServicePort {
	
	LocalModel findById(Long id) throws LocalNotFoundException;

	List<LocalModel> findAll();
	
	LocalModel saveLocal(LocalModel localModel);
	
	LocalModel updateLocalById(Long id, LocalModel localModel) throws LocalNotFoundException;
	
	void deleteById(Long id) throws LocalNotFoundException;
}

package com.nxhu.restfull_api.service;

import java.util.List;
import java.util.Optional;

import com.nxhu.restfull_api.exception.LocalNotFoundException;
import com.nxhu.restfull_api.persistence.entity.LocalEntity;

public interface ILocalService {

	List<LocalEntity> findAllLocals();
	
	LocalEntity saveLocal(LocalEntity local);
	
	LocalEntity updateLocal(Long id, LocalEntity local) throws LocalNotFoundException;
	
	void deleteLocal(Long id) throws LocalNotFoundException;
	
	Optional<LocalEntity> findByNameIgnoreCase(String name); 
	
	LocalEntity findLocalById(Long id) throws LocalNotFoundException;
}

package com.nxhu.restfull_api.local.infrastructure.adapters.output.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.nxhu.restfull_api.local.domain.model.LocalModel;
import com.nxhu.restfull_api.local.infrastructure.adapters.output.persistence.entity.LocalEntity;

@Mapper(componentModel = "spring")
public interface LocalPersistenceMapper {

	LocalEntity toLocalEntity(LocalModel localModel);
	
	LocalModel toLocalModel(LocalEntity localEntity);
	
	List<LocalModel> toLocalList(List<LocalEntity> localEntities);
}

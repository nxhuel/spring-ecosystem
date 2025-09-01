package com.nxhu.restfull_api.Local.infrastructure.adapters.input.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.nxhu.restfull_api.Local.domain.model.LocalModel;
import com.nxhu.restfull_api.Local.infrastructure.adapters.input.rest.model.request.LocalCreateRequest;
import com.nxhu.restfull_api.Local.infrastructure.adapters.input.rest.model.response.LocalResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocalRestMapper {

	LocalModel toLocalModel(LocalCreateRequest localCreateRequest);
	
	LocalResponse toLocalResponse(LocalModel localModel);
	
	List<LocalResponse> toLocalResponseList(List<LocalModel> localModelList);
}

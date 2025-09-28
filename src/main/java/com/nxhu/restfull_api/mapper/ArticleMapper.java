package com.nxhu.restfull_api.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.nxhu.restfull_api.dto.request.ArticleRequest;
import com.nxhu.restfull_api.dto.response.ArticleResponse;
import com.nxhu.restfull_api.persistence.entity.ArticleEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArticleMapper {
	
	ArticleEntity toArticleEntity(ArticleRequest articleRequest);
	
	ArticleResponse toArticleResponse(ArticleEntity articleEntity);
	
	List<ArticleResponse> toArticleResponses(List<ArticleEntity> articleEntities);

}

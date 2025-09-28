package com.nxhu.restfull_api.service;

import java.util.List;
import java.util.Map;

import com.nxhu.restfull_api.exception.ArticleNotFoundException;
import com.nxhu.restfull_api.persistence.entity.ArticleEntity;

public interface ArticleService {

	ArticleEntity saveArticle(ArticleEntity articleEntity);
	
	List<ArticleEntity> findAllArticles();
	
	ArticleEntity findArticleById(Long id) throws ArticleNotFoundException;
	
	ArticleEntity patchArticleById(Long id, Map<String, Object> updates) throws ArticleNotFoundException;
	
	void deleteArticleById(Long id) throws ArticleNotFoundException;
}

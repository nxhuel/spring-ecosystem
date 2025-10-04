package com.nxhu.restfull_api.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nxhu.restfull_api.exception.ArticleNotFoundException;
import com.nxhu.restfull_api.persistence.entity.ArticleEntity;
import com.nxhu.restfull_api.persistence.repository.ArticleRepository;
import com.nxhu.restfull_api.service.ArticleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
	
	private final ArticleRepository articleRepository;
	
	@Override
	public ArticleEntity saveArticle(ArticleEntity articleEntity) {
		return articleRepository.save(articleEntity);
	}

	@Override
	public List<ArticleEntity> findAllArticles() {
		return articleRepository.findAll();
	}

	@Override
	public ArticleEntity findArticleById(Long id) throws ArticleNotFoundException {
		return articleRepository.findById(id)
				.orElseThrow(() -> new ArticleNotFoundException("Article with ID: " + id + " not found"));
	}

	@Override
	public ArticleEntity patchArticleById(Long id, Map<String, Object> updates) throws ArticleNotFoundException {
		ArticleEntity updatedArticle = articleRepository.findById(id)
				.orElseThrow(() -> new ArticleNotFoundException("Article with ID: " + id + " not found"));
		
		updates.forEach((key, value) -> {
			switch (key) {
			case "title" -> updatedArticle.setTitle((String) value);
			case "description" -> updatedArticle.setDescription((String) value);
			case "totalPages" -> {
			    if (value != null) {
			        updatedArticle.setTotalPages(Integer.parseInt(value.toString()));
			    };
			}
			case "publicationDate" -> {
				if (value != null && !value.toString().isBlank()) {
					updatedArticle.setPublicationDate(LocalDate.parse(value.toString()));
				}
			}
			}
		});
		
		return articleRepository.save(updatedArticle);
	}

	@Override
	public void deleteArticleById(Long id) throws ArticleNotFoundException {
		if (articleRepository.findById(id).isEmpty()) {
			throw new ArticleNotFoundException("Article with ID: " + id + " not found");
		}
		
		articleRepository.deleteById(id);
	}

}

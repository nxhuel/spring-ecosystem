package com.nxhu.restfull_api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nxhu.restfull_api.dto.request.ArticleRequest;
import com.nxhu.restfull_api.dto.response.ArticleResponse;
import com.nxhu.restfull_api.exception.ArticleNotFoundException;
import com.nxhu.restfull_api.mapper.ArticleMapper;
import com.nxhu.restfull_api.persistence.entity.ArticleEntity;
import com.nxhu.restfull_api.service.ArticleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

	private final ArticleService articleService;
	private final ArticleMapper mapper;
	
	@PostMapping("/api/v1")
	public ResponseEntity<ArticleResponse> saveArticle(@Valid @RequestBody ArticleRequest articleRequest) {
		ArticleEntity articleEntity = articleService.saveArticle(mapper.toArticleEntity(articleRequest));
//		
//		System.out.println("[LOG]: " + articleRequest.getTotalPages());
//		System.out.println("[LOG]: " + articleRequest.getPublicationDate());
//		System.out.println("------------------------------------------------");
//		System.out.println("[LOG]: " + articleEntity.getTotalPages());
//		System.out.println("[LOG]: " + articleEntity.getPublicationDate());
//		
		ArticleResponse response = mapper.toArticleResponse(articleEntity);
		return new ResponseEntity<ArticleResponse>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/api/v1")
	public ResponseEntity<List<ArticleResponse>> findAllArticles() {
		List<ArticleResponse> respose = mapper.toArticleResponses(articleService.findAllArticles());
		return new ResponseEntity<List<ArticleResponse>>(respose, HttpStatus.OK);
	}
	
	@GetMapping("/api/v1/{id}")
	public ResponseEntity<ArticleResponse> findArticleById(@PathVariable Long id) throws ArticleNotFoundException {
		ArticleEntity articleEntity = articleService.findArticleById(id);
		ArticleResponse response = mapper.toArticleResponse(articleEntity);
		return new ResponseEntity<ArticleResponse>(response, HttpStatus.OK);
	}
	
	@PatchMapping("/api/v1/{id}")
	public ResponseEntity<ArticleResponse> patchArticleById(@PathVariable Long id, @RequestBody Map<String, Object> updates) throws ArticleNotFoundException {
		ArticleEntity articleEntity = articleService.patchArticleById(id, updates);
		ArticleResponse response = mapper.toArticleResponse(articleEntity);
		return new ResponseEntity<ArticleResponse>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/api/v1/{id}")
	public ResponseEntity<String> deleteArticleById(@PathVariable Long id) throws ArticleNotFoundException {
		articleService.deleteArticleById(id);
		return new ResponseEntity<String>("Article successfully deleted", HttpStatus.OK);
	}
}

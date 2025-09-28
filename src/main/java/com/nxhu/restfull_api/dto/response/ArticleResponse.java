package com.nxhu.restfull_api.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleResponse {

	private Long id;
	
	private String title;
	
	private String description;
	
	private int totalPages;
	
	private LocalDate publicationDate;
}

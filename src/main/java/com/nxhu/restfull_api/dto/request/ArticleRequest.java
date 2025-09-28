package com.nxhu.restfull_api.dto.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
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
public class ArticleRequest {

	@NotBlank(message = "The title must not be empty")
	private String title;
	
	@NotBlank(message = "The description must not be empty")
	private String description;
	
	@NotNull(message = "The number of pages is mandatory")
	private int totalPages;
	
	@PastOrPresent(message = "The publication date cannot be in the future")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate publicationDate;
}

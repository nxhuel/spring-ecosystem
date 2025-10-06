package com.nxhu.restfull_api.dto.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChatMessageRequest {
	private String from;
	private String message;
	private LocalDateTime timestamp;

}

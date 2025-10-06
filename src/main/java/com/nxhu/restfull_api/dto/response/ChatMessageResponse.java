package com.nxhu.restfull_api.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChatMessageResponse {
	private String from;
	private String message;
	private LocalDateTime timestamp;
}

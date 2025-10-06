package com.nxhu.restfull_api.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nxhu.restfull_api.dto.request.ChatMessageRequest;
import com.nxhu.restfull_api.dto.response.ChatMessageResponse;
import com.nxhu.restfull_api.persistence.entity.ChatMessageEntity;
import com.nxhu.restfull_api.service.ChatMessageService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class WebSocketController {
	
	private final ChatMessageService chatMessageService;

	@MessageMapping("/chat/{roomId}")
	@SendTo("/topic/{roomId}") // redireccion de cuando llegue el msg
	public ChatMessageResponse chat(@DestinationVariable String roomId, ChatMessageRequest message) {
		System.out.println(message);
		
		ChatMessageEntity chatMessageEntity = new ChatMessageEntity();
		chatMessageEntity.setUserName(message.getFrom());
		chatMessageEntity.setMessage(message.getMessage());
		chatMessageEntity.setTimestamp(LocalDateTime.now());
		chatMessageEntity.setRoomId(roomId);
		
		chatMessageService.saveChatMessage(chatMessageEntity);
		
//		return new ChatMessageResponse(message.getFrom(), message.getMessage(), message.getTimestamp());
	    return new ChatMessageResponse(
	            chatMessageEntity.getUserName(),
	            chatMessageEntity.getMessage(),
	            chatMessageEntity.getTimestamp()
	        );
	}

	@GetMapping("/api/chat/{roomId}")
	public ResponseEntity<List<ChatMessageEntity>> getAllChatMessages(@PathVariable String roomId) {
		List<ChatMessageEntity> result = chatMessageService.findByRoomById(roomId); 
		return new ResponseEntity<List<ChatMessageEntity>>(result, HttpStatus.OK);
		
	}
}

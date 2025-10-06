package com.nxhu.restfull_api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nxhu.restfull_api.persistence.entity.ChatMessageEntity;
import com.nxhu.restfull_api.persistence.repository.ChatMessageRepository;
import com.nxhu.restfull_api.service.ChatMessageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {
	
	private final ChatMessageRepository chatMessageRepository;
	
	@Override
	public ChatMessageEntity saveChatMessage(ChatMessageEntity chatMessage) {
//		chatMessage.setTimestamp(LocalDateTime.now());
		return chatMessageRepository.save(chatMessage);
	}

	@Override
	public List<ChatMessageEntity> findByRoomById(String roomId) {
		return chatMessageRepository.findByRoomId(roomId);
	}

}

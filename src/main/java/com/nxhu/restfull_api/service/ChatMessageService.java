package com.nxhu.restfull_api.service;

import java.util.List;

import com.nxhu.restfull_api.persistence.entity.ChatMessageEntity;

public interface ChatMessageService {

	ChatMessageEntity saveChatMessage(ChatMessageEntity chatMessage);
	
	List<ChatMessageEntity> findByRoomById(String roomId);
}

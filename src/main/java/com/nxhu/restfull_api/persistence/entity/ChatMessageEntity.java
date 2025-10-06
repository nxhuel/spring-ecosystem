package com.nxhu.restfull_api.persistence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "tbl_chat")
public class ChatMessageEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	from
	@Column(name = "user_name")
	private String userName;
	
	private String message;
	
	@Column(name = "timestamp", columnDefinition = "DATETIME")
	private LocalDateTime timestamp;
	
	@Column(name = "room_id")
	private String roomId;

}

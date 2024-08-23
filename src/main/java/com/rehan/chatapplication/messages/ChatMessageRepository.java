package com.rehan.chatapplication.messages;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ChatMessageRepository extends CrudRepository<ChatMessage,Integer> {

    List<ChatMessage> findChatMessagesByRoomId(int roomId);
}

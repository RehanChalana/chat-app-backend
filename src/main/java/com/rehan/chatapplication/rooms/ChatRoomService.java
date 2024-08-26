package com.rehan.chatapplication.rooms;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public ChatRoomService(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository=chatRoomRepository;
    }

    public List<ChatRoom> findByUserId(int userId) {
        return chatRoomRepository.findByUserId(userId);
    }


}

package com.rehan.chatapplication.chatrooms;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public ChatRoomService(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository=chatRoomRepository;
    }

    public List<ChatRoom> findAll() {
        return chatRoomRepository.findAll();
    }


}

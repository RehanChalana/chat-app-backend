package com.rehan.chatapplication.chatrooms;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRoomRestController {

    private final ChatRoomService chatRoomService;

    public ChatRoomRestController(ChatRoomService chatRoomService) {
        this.chatRoomService=chatRoomService;
    }

    @GetMapping("/chatrooms")
    public List<ChatRoom> findAll() {
        return chatRoomService.findAll();
    }

}

package com.rehan.chatapplication.rooms;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRoomRestController {

    private final ChatRoomService chatRoomService;

    public ChatRoomRestController(ChatRoomService chatRoomService) {
        this.chatRoomService=chatRoomService;
    }

    @GetMapping("/chatrooms/{userId}")
    public List<ChatRoom> findByUserId(@PathVariable int userId) {
        return chatRoomService.findByUserId(userId);
    }

}

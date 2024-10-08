package com.rehan.chatapplication.messages;

import java.util.List;

import com.rehan.chatapplication.messages.dto.MessageRequestDTO;
import com.rehan.chatapplication.messages.dto.MessageResponseDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatMessageRestController {

    private final ChatMessageService chatMessageService;

    public ChatMessageRestController(ChatMessageService chatMessageService) {
        this.chatMessageService=chatMessageService;
    }

    @CrossOrigin
    @GetMapping("/messages/{roomId}")
    public List<MessageResponseDTO> getMessageByRoomId(@PathVariable int roomId) {
        return chatMessageService.findChatMessagesByRoomId(roomId);
    }
}

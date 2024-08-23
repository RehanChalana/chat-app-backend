package com.rehan.chatapplication.messages;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class ChatMessageController {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @MessageMapping("messages/{roomId}")
    @SendTo("/chat/messages/{roomId}")
    public ChatMessage sendToRoom(@DestinationVariable String roomId, ChatMessage message) {
        chatMessageRepository.save(message);
        log.info(message.getMessageText());
        return message;
    }

}

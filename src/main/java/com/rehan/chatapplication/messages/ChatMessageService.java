package com.rehan.chatapplication.messages;

import java.util.List;
import java.util.stream.Collectors;

import com.rehan.chatapplication.messages.dto.ChatMessageMapper;
import com.rehan.chatapplication.messages.dto.MessageResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatMessageMapper messageMapper;

    public ChatMessageService(ChatMessageRepository chatMessageRepository, ChatMessageMapper messageMapper) {
        this.chatMessageRepository=chatMessageRepository;
        this.messageMapper=messageMapper;
    }

    public List<MessageResponseDTO> findChatMessagesByRoomId(int roomId) {
        List<ChatMessage> messages = chatMessageRepository.findChatMessagesByRoomId(roomId);
        return messages.stream().map(messageMapper::entityToDTO).collect(Collectors.toList());
    }

}

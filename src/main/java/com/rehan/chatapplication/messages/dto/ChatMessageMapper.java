package com.rehan.chatapplication.messages.dto;

import com.rehan.chatapplication.messages.ChatMessage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChatMessageMapper {
    MessageResponseDTO entityToDTO(ChatMessage entity);
    ChatMessage DTOToEntity(MessageRequestDTO dto);
}

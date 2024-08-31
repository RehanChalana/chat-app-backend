package com.rehan.chatapplication.rooms.dto;

import com.rehan.chatapplication.rooms.ChatRoom;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChatRoomMapper {
    RoomResponseDTO entityToResponseDTO(ChatRoom entity);
    ChatRoom requestDTOtoEntity(RoomRequestDTO requestDTO);
}

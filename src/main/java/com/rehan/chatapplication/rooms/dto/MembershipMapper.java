package com.rehan.chatapplication.rooms.dto;

import com.rehan.chatapplication.rooms.ChatRoom;
import com.rehan.chatapplication.rooms.RoomMembership;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MembershipMapper {
    @Mapping(target = "roomId", source = "entity.chatRoom.roomId")
    MembershipResponseDTO entityToResponseDTO(RoomMembership entity);

    @Mapping(source = "room", target = "chatRoom" )
    @Mapping(source = "requestDTO.userId", target = "userId")
    RoomMembership requestDTOToEntity(MembershipRequestDTO requestDTO, ChatRoom room);
}

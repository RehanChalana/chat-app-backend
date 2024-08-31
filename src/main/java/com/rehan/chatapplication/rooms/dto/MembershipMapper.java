package com.rehan.chatapplication.rooms.dto;

import com.rehan.chatapplication.rooms.RoomMembership;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MembershipMapper {
    @Mapping(target = "roomId", source = "entity.chatRoom.roomId")
    MembershipResponseDTO entityToResponseDTO(RoomMembership entity);
}

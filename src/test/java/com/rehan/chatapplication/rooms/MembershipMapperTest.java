package com.rehan.chatapplication.rooms;

import com.rehan.chatapplication.rooms.dto.MembershipMapper;
import com.rehan.chatapplication.rooms.dto.MembershipResponseDTO;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MembershipMapperTest {

    private MembershipMapper membershipMapper = Mappers.getMapper(MembershipMapper.class);

    @Test
    public void entityToMemberShipResponseDTOTest() {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setRoomId(5);
        chatRoom.setName("General");
        chatRoom.setUserId(4);

        RoomMembership memberships = new RoomMembership();
        memberships.setMembershipId(1);
        memberships.setChatRoom(chatRoom);
        memberships.setUserId(4);

        MembershipResponseDTO responseDTO = membershipMapper.entityToResponseDTO(memberships);

        assertEquals(5,responseDTO.roomId());
        assertEquals(1,responseDTO.membershipId());
        assertEquals(4,responseDTO.userId());
    }

}

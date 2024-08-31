package com.rehan.chatapplication.rooms;

import java.util.List;

import com.rehan.chatapplication.rooms.dto.ChatRoomMapper;
import com.rehan.chatapplication.rooms.dto.RoomRequestDTO;
import com.rehan.chatapplication.rooms.dto.RoomResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomMapper roomMapper;

    public ChatRoomService(ChatRoomRepository chatRoomRepository, ChatRoomMapper roomMapper) {
        this.chatRoomRepository = chatRoomRepository;
        this.roomMapper = roomMapper;
    }

    public RoomResponseDTO createNewRoom(RoomRequestDTO requestDTO) {
        ChatRoom entity = chatRoomRepository.save(roomMapper.requestDTOtoEntity(requestDTO));
        return roomMapper.entityToResponseDTO(entity);
    }




}

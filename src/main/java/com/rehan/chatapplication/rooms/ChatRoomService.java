package com.rehan.chatapplication.rooms;

import java.util.List;
import java.util.Optional;

import com.rehan.chatapplication.rooms.dto.ChatRoomMapper;
import com.rehan.chatapplication.rooms.dto.RoomRequestDTO;
import com.rehan.chatapplication.rooms.dto.RoomResponseDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.toList;

@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomMapper roomMapper;
    private final RoomMembershipRepository membershipRepository;

    public ChatRoomService(ChatRoomRepository chatRoomRepository, ChatRoomMapper roomMapper, RoomMembershipRepository membershipRepository) {
        this.chatRoomRepository = chatRoomRepository;
        this.roomMapper = roomMapper;
        this.membershipRepository=membershipRepository;
    }

    public RoomResponseDTO createNewRoom(@Valid RoomRequestDTO requestDTO) {
        ChatRoom entity = chatRoomRepository.save(roomMapper.requestDTOtoEntity(requestDTO));
        return roomMapper.entityToResponseDTO(entity);
    }

    public List<RoomResponseDTO> findByUserId(int userId) {
        List<RoomMembership> memberships = membershipRepository.findByUserId(userId);
        return memberships.stream().map(membership -> findById(membership.getMembershipId())).toList();
    }

     public RoomResponseDTO findById(int roomId) {
        Optional<ChatRoom> room =  chatRoomRepository.findById(roomId);
        if(room.isEmpty()) return null;
        return roomMapper.entityToResponseDTO(room.get());
     }





}

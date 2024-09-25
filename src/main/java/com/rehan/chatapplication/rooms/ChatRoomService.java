package com.rehan.chatapplication.rooms;

import java.util.List;
import java.util.Optional;

import com.rehan.chatapplication.rooms.dto.ChatRoomMapper;
import com.rehan.chatapplication.rooms.dto.MembershipRequestDTO;
import com.rehan.chatapplication.rooms.dto.MembershipResponseDTO;
import com.rehan.chatapplication.rooms.dto.RoomRequestDTO;
import com.rehan.chatapplication.rooms.dto.RoomResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomMapper roomMapper;
    private final RoomMembershipService membershipService;

    public ChatRoomService(ChatRoomRepository chatRoomRepository, ChatRoomMapper roomMapper, RoomMembershipService membershipService) {
        this.chatRoomRepository = chatRoomRepository;
        this.roomMapper = roomMapper;
        this.membershipService = membershipService;
    }

    public RoomResponseDTO createNewRoom(@Valid RoomRequestDTO requestDTO) {
        ChatRoom entity = roomMapper.requestDTOtoEntity(requestDTO);
        ChatRoom savedEntity = chatRoomRepository.save(entity);
        MembershipRequestDTO request = new MembershipRequestDTO(requestDTO.userId(), savedEntity.getRoomId());
        log.info(request.toString());
        membershipService.createNewMembership(request);
        return roomMapper.entityToResponseDTO(savedEntity);
    }

    public List<RoomResponseDTO> findByUserId(int userId) {
        List<MembershipResponseDTO> memberships = membershipService.findByUserId(userId);
        return memberships.stream().map(membership -> findById(membership.membershipId())).toList();
    }

     public RoomResponseDTO findById(int roomId) {
        ChatRoom room = chatRoomRepository.findById(roomId).orElseThrow(() -> new EntityNotFoundException());
        return roomMapper.entityToResponseDTO(room);
     }

}

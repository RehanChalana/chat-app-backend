package com.rehan.chatapplication.rooms;

import java.util.List;

import com.rehan.chatapplication.rooms.dto.MembershipMapper;
import com.rehan.chatapplication.rooms.dto.MembershipRequestDTO;
import com.rehan.chatapplication.rooms.dto.MembershipResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoomMembershipService {

    private final RoomMembershipRepository roomMembershipRepository;
    private final MembershipMapper membershipMapper;
    private final ChatRoomRepository roomRepository;

    public RoomMembershipService(RoomMembershipRepository roomMembershipRepository, MembershipMapper membershipMapper, ChatRoomRepository roomRepository) {
        this.roomMembershipRepository = roomMembershipRepository;
        this.membershipMapper = membershipMapper;
        this.roomRepository = roomRepository;
    }

    public MembershipResponseDTO createNewMembership(MembershipRequestDTO requestDTO) {
        ChatRoom room = roomRepository.findById(requestDTO.roomId()).orElseThrow(() -> new EntityNotFoundException());
        RoomMembership entity = membershipMapper.requestDTOToEntity(requestDTO,room);
        log.info(entity.toString());
        RoomMembership savedEntity = roomMembershipRepository.save(entity);
        return membershipMapper.entityToResponseDTO(savedEntity);
    }

    public List<MembershipResponseDTO> findAll() {
        List<RoomMembership> memberships = roomMembershipRepository.findAll();
        return memberships.stream().map(membershipMapper::entityToResponseDTO).toList();
    }

    public MembershipResponseDTO findById(int id) {
        RoomMembership membership = roomMembershipRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return membershipMapper.entityToResponseDTO(membership);
    }

    public List<MembershipResponseDTO> findByUserId(int userId) {
        List<RoomMembership> memberships = roomMembershipRepository.findAllByUserId(userId);
        return memberships.stream().map(membershipMapper::entityToResponseDTO).toList();
    }


}

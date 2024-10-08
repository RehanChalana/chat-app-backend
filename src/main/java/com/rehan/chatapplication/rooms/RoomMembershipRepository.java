package com.rehan.chatapplication.rooms;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RoomMembershipRepository extends CrudRepository<RoomMembership,Integer> {
   List<RoomMembership> findAll();

   List<RoomMembership> findAllByUserId(int userId);
}

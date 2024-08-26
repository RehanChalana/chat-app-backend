package com.rehan.chatapplication.rooms;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ChatRoomRepository extends CrudRepository<ChatRoom,Integer> {

    List<ChatRoom> findByUserId(int id);
}

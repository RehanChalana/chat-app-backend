package com.rehan.chatapplication.chatrooms;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ChatRoomRepository extends CrudRepository<ChatRoom,Integer> {

    List<ChatRoom> findAll();
}

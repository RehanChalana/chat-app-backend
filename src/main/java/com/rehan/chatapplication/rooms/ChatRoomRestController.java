package com.rehan.chatapplication.rooms;

import java.util.List;

import com.rehan.chatapplication.rooms.dto.RoomRequestDTO;
import com.rehan.chatapplication.rooms.dto.RoomResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRoomRestController {

    private final ChatRoomService chatRoomService;

    public ChatRoomRestController(ChatRoomService chatRoomService) {
        this.chatRoomService=chatRoomService;
    }

    @PostMapping("/rooms")
   public RoomResponseDTO createNewRoom(@RequestBody RoomRequestDTO requestDTO) {
        return chatRoomService.createNewRoom(requestDTO);
   }

}

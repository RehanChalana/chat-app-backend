package com.rehan.chatapplication.chatrooms.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ChatRoomDTO(
        @NotNull @Positive Integer roomId,
        @NotNull @Size(max = 50) String name,
        @NotNull @Positive Integer userId
) {
}

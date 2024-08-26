package com.rehan.chatapplication.rooms.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record RoomResponseDTO(
        @NotNull @Positive Integer roomId,
        @NotNull @Size(max = 50) String name,
        @NotNull @Positive Integer userId
) {
}

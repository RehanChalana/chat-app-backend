package com.rehan.chatapplication.rooms.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record MembershipRequestDTO(
        @NotNull @Positive int userId,
        @NotNull @Positive int roomId
) {
}

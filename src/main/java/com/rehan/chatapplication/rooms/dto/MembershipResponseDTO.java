package com.rehan.chatapplication.rooms.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record MembershipResponseDTO (
        @NotNull @Positive int membershipId,
        @NotNull @Positive int userId,
        @NotNull @Positive int roomId
) {
}

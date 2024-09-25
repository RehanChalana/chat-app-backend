package com.rehan.chatapplication.messages.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record MessageResponseDTO (
        @NotNull @Positive int messageId,
        @NotNull @Size(min = 3, max = 25) String username,
        @NotNull @Positive Integer senderId,
        @Positive Integer receiverId,
        @Positive Integer roomId,
        @NotNull @Min(1) String messageText,
        @Past @NotNull LocalDateTime sendAt
) {
}

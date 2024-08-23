package com.rehan.chatapplication.messages;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="messages")
@Getter
@Setter
public class ChatMessage {

    @Id
    @Column(name = "message_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;

    @Column(name = "sender_id")
    private Integer senderId;

    @Column(name = "receiver_id")
    private Integer receiverId;

    @Column(name = "room_id")
    private Integer roomId;

    @Column(name = "message_text")
    private String messageText;

    @Column(name = "sent_at")
    private LocalDateTime sendAt;

    @Column(name = "username")
    private String username;
}

package com.rehan.chatapplication.rooms;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "room_memberships")
@Entity
@Getter
@Setter
public class RoomMembership {

    @Id
    @Column(name = "membership_id")
    private int membershipId;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private ChatRoom chatRoom;

    @Column(name = "user_id")
    private int userId;
}

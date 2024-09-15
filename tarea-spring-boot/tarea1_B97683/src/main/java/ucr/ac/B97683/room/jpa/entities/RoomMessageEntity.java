package ucr.ac.B97683.room.jpa.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "B97683_ROOM_MESSAGE")
public class RoomMessageEntity {
    @Id
    @Column(name = "ID")
    private UUID id;
    @Column(name = "CREATEDON")
    private OffsetDateTime createdOn;
    @Column(name = "MESSAGE")
    private String message;
    @Column(name="ROOMID")
    private UUID roomID;
    @Column(name="CREATEDBY")
    private String sentBy;

    public RoomMessageEntity() {

    }

    public RoomMessageEntity(String message, UUID roomID, String sentBy) {
        this.id = UUID.randomUUID();
        this.createdOn = OffsetDateTime.now(ZoneOffset.of("-06:00"));
        this.sentBy = sentBy;
        this.roomID = roomID;
        this.message = message;
    }

    public OffsetDateTime getCreatedOn() {
        return createdOn;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UUID getRoomID() {
        return roomID;
    }

    public void setRoomID(UUID roomID) {
        this.roomID = roomID;
    }

    public String getSentBy() {
        return sentBy;
    }

    public void setSentBy(String sentBy) {
        this.sentBy = sentBy;
    }
}

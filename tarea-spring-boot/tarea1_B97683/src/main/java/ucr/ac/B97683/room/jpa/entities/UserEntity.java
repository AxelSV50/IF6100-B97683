package ucr.ac.B97683.room.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "B97683_USER")
public class UserEntity {
    @Id
    @Column(name="ID")
    private UUID id;
    @Column(name="ALIAS")
    private String alias;
    @Column(name="ROOMID")
    private UUID roomID;

    public UserEntity(String alias, UUID roomID) {
        this.id = UUID.randomUUID();
        this.alias = alias;
        this.roomID = roomID;
    }

    public UserEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public UUID getRoomID() {
        return roomID;
    }

    public void setRoomID(UUID roomID) {
        this.roomID = roomID;
    }
}

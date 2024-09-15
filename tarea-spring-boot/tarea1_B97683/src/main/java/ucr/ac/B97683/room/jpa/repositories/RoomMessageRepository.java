package ucr.ac.B97683.room.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucr.ac.B97683.room.jpa.entities.RoomMessageEntity;
import ucr.ac.B97683.room.jpa.entities.UserEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface RoomMessageRepository extends JpaRepository<RoomMessageEntity, UUID> {

    List<RoomMessageEntity> findByRoomID(UUID roomID);
}

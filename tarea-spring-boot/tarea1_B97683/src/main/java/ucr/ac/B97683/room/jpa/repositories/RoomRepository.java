package ucr.ac.B97683.room.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucr.ac.B97683.room.jpa.entities.RoomEntity;
import ucr.ac.B97683.room.jpa.entities.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, UUID> {

    Optional<RoomEntity> findById(UUID id);
}

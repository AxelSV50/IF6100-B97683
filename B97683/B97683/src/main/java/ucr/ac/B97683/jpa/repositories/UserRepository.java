package ucr.ac.B97683.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucr.ac.B97683.jpa.entities.UserEntity;

import java.util.UUID;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}

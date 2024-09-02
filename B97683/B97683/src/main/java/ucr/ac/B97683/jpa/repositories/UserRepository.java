package ucr.ac.B97683.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucr.ac.B97683.jpa.entities.UserEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByEmail(String email);

    Long countByEmail(String email);


    //@Query(nativeQuery = true, value = "SELECT * FROM users WHERE name = :name")//SQL
    //@Query("SELECT u FROM UserEntity u WHERE u.name = :name")// HQL
    List<UserEntity> findByName(String name);

}

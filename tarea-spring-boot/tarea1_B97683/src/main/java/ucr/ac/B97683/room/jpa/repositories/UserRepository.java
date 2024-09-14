package ucr.ac.B97683.room.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ucr.ac.B97683.room.jpa.entities.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository  extends JpaRepository<UserEntity, UUID> {

    /*
        ¿Qué hace el Repositorio?
            Me ayuda a realizar acciones en una tabla asociada a una entidad.

        IMPORTANTE: JpaRepository tiene una estructura para estos métodos en sus nombres, el primer verbo
        indica la acción a realizar en la tabla. Después de ello, se coloca el nombre del atributo
        sobre el cual se ralizará la acción (Debe ser el mismo que en la entidad). No importa el parámetro.
     */
    List<UserEntity> findByRoomID(UUID roomID);
    Optional<UserEntity> findByAlias(String alias);
}

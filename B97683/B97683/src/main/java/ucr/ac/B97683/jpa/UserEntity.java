package ucr.ac.B97683.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    private UUID id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;


}

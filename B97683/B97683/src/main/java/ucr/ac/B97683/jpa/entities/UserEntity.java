package ucr.ac.B97683.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

//Se importó JBC en gradle.kts -> 	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//ORM: Thibernate


//PARA VER LA BASE DE DATOS EN TIEMPO REAL USO localhost:8080/h2
@Entity
@Table(name = "users")
public class UserEntity {


    //Código único de baja incidencia, evita duplicidad de IDs
    //Cédula es dato de negocio y no va aquí
    @Id
    private UUID id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

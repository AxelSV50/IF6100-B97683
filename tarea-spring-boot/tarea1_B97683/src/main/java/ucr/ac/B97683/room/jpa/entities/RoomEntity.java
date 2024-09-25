package ucr.ac.B97683.room.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

//Se importó JBC en gradle.kts -> 	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//ORM: Thibernate


//PARA VER LA BASE DE DATOS EN TIEMPO REAL USO localhost:8080/h2
@Entity
@Table(name = "B97683_ROOM")
public class RoomEntity {

    @Id
    @Column(name="ID")
    private UUID id;
    @Column(name="NAME")
    private String name;
    @Column(name="CREATEDBY")
    private String createdBy;

    public RoomEntity(String name, String createdBy) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.createdBy = createdBy;
    }

    //Lo pide h2
    public RoomEntity() {
    }

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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}

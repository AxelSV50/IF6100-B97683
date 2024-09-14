package ucr.ac.B97683.room.api.types;

//Datos que llevará el JSON
public record CreateRoomRequest(
        String name,
        String createdBy
) {
}
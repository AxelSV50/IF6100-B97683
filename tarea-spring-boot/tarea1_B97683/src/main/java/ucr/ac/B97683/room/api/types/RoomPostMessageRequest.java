package ucr.ac.B97683.room.api.types;

import java.util.UUID;

public record RoomPostMessageRequest(
        UUID id,
        String alias,
        String message
){
}

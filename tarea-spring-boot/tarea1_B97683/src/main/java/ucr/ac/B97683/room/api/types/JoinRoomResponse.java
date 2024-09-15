package ucr.ac.B97683.room.api.types;

import java.util.UUID;

public record JoinRoomResponse(
        UUID id,
        String name,
        String [] users
) {
}

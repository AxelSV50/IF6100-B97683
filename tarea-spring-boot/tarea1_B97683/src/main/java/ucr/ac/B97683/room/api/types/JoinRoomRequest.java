package ucr.ac.B97683.room.api.types;

import java.util.UUID;

public record JoinRoomRequest(
        UUID id,
        String alias
) {
}

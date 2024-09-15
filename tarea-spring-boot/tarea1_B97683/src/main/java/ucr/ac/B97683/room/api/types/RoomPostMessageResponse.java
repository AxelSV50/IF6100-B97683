package ucr.ac.B97683.room.api.types;

import java.time.OffsetDateTime;
import java.util.UUID;

public record RoomPostMessageResponse(
        UUID id,
        OffsetDateTime createdOn,
        String message
) {
}

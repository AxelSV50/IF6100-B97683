package ucr.ac.B97683.room.api.types;

import java.time.OffsetDateTime;
import java.util.UUID;

public record RoomGetAllMessagesResponse(
        UUID id,
        String name,
        RoomGetMessageResponse [] messages
) {
}

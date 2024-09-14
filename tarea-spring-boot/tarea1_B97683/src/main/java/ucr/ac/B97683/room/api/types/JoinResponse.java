package ucr.ac.B97683.room.api.types;

import java.util.UUID;

public record JoinResponse(
        UUID id,
        String name,
        String [] users
) {
}

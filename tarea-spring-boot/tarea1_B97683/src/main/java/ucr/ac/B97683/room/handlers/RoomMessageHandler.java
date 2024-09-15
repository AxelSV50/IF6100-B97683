package ucr.ac.B97683.room.handlers;


import ucr.ac.B97683.room.api.types.RoomGetMessageResponse;
import ucr.ac.B97683.room.jpa.entities.RoomMessageEntity;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public interface RoomMessageHandler {

    //Entradas
    record PostMessageCommand(UUID roomID, String alias, String message){}
    record GetMessagesCommand(UUID roomID) {}


    sealed interface Result {

        // POST
        record PostMessageSuccess(UUID roomID, OffsetDateTime createdOn, String message) implements Result {}
        record PostMessageInvalidData(String... fields) implements Result {}

        // GET
        record GetMessagesSuccess (UUID roomID, String name, RoomGetMessageResponse [] messages) implements Result {}
        record GetMessagesInvalidData (String idField) implements Result {}

    }

    Result sendMessage (PostMessageCommand command);
    Result getAllMessages (GetMessagesCommand command);

}

package ucr.ac.B97683.room.handlers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ucr.ac.B97683.room.api.types.RoomGetMessageResponse;
import ucr.ac.B97683.room.handlers.RoomMessageHandler;
import ucr.ac.B97683.room.jpa.entities.RoomMessageEntity;
import ucr.ac.B97683.room.jpa.entities.UserEntity;
import ucr.ac.B97683.room.jpa.repositories.RoomMessageRepository;
import ucr.ac.B97683.room.jpa.repositories.RoomRepository;
import ucr.ac.B97683.room.jpa.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoomMessageHandlerImpl implements RoomMessageHandler {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    RoomMessageRepository messageRepository;

    @Override
    public Result sendMessage(PostMessageCommand command) {

        //Validar espacios nulos o en blanco
        Result.PostMessageInvalidData invalidData = checkInvalidFields(command);
        if(invalidData != null){
            return invalidData;
        }

        //Validar que la sala exista
        var currentRoom = roomRepository.findById(command.roomID());
        if(currentRoom.isEmpty()){
            return null;
        }

        //Validar que el alias exista en la sala
        var currentUser = userRepository.findByAliasAndRoomID(command.alias(), command.roomID());
        if(currentUser.isEmpty()){
            return null;
        }

        //Guardar el mensaje en la BD
        var message = mapToRoomMessageEntity(command);
        messageRepository.save(message);

        return new Result.PostMessageSuccess(
                command.roomID(),
                message.getCreatedOn(),
                command.message()
        );
    }

    @Override
    public Result getAllMessages(GetMessagesCommand command) {

        //Validar el campo de UUID
        if(command.roomID() == null){
            return null;
        }
        //Validar que la sala exista
        var currentRoom = roomRepository.findById(command.roomID());
        if(currentRoom.isEmpty()){
            return null;
        }

        //Obtener todos los mensajes de la sala
        List<RoomMessageEntity> messagesList = messageRepository.findByRoomID(command.roomID());

        return new Result.GetMessagesSuccess(
                command.roomID(),
                currentRoom.get().getName(),
                toFormatMessagesArray(messagesList)
        );
    }

    private RoomMessageEntity mapToRoomMessageEntity(PostMessageCommand command) {
        return new RoomMessageEntity(command.message(), command.roomID(), command.alias());
    }

    private Result.PostMessageInvalidData checkInvalidFields(PostMessageCommand command) {
        List<String> invalidFields = new ArrayList<>();

        if (command.alias() == null || command.alias().isBlank()) {
            invalidFields.add("alias");
        }
        if (command.roomID() == null || command.roomID().toString().isBlank()) {
            invalidFields.add("id");
        }
        if (command.message() == null || command.message().isBlank()) {
            invalidFields.add("message");
        }
        if (!invalidFields.isEmpty()) {
            return new Result.PostMessageInvalidData(invalidFields.toArray(new String[0]));
        } else return null;
    }

    private Result.GetMessagesInvalidData checkInvalidFields(GetMessagesCommand command) {

        if (command.roomID() == null) {
            return new Result.GetMessagesInvalidData("idField");
        } else return null;
    }

    private RoomGetMessageResponse [] toFormatMessagesArray(List<RoomMessageEntity> messagesList) {

        RoomGetMessageResponse [] formatMessages = new RoomGetMessageResponse[messagesList.size()];

        int i = 0;
        for(RoomMessageEntity message :messagesList) {

            formatMessages[i] = new RoomGetMessageResponse(message.getSentBy(), message.getMessage(), message.getCreatedOn());
            i++;
        }

        return formatMessages;
    }
}

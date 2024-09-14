package ucr.ac.B97683.room.handlers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ucr.ac.B97683.room.handlers.CreateRoomHandler;
import ucr.ac.B97683.room.handlers.JoinRoomHandler;
import ucr.ac.B97683.room.jpa.entities.RoomEntity;
import ucr.ac.B97683.room.jpa.entities.UserEntity;
import ucr.ac.B97683.room.jpa.repositories.RoomRepository;
import ucr.ac.B97683.room.jpa.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateRoomHandlerImpl implements CreateRoomHandler {

    //Autowired Establece esto como obligatorio
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Result createRoom(Command command) {

        //Si existen datos inválidos
        Result.InvalidData invalidData = checkInvalidFields(command);
        if(invalidData != null){
            return invalidData;
        }

        //Crear la sala y el usuario que la creó
        var room = mapToRoomEntity(command);
        var user = mapRoomEntityToUserEntity(room);
        roomRepository.save(room);
        userRepository.save(user);
        return new Result.Success(room.getId().toString());
    }

    private Result.InvalidData checkInvalidFields(Command command) {
        List<String> invalidFields = new ArrayList<>();

        if (command.name() == null || command.name().isBlank()) {
            invalidFields.add("name");
        }
        if (command.createdBy() == null || command.createdBy().isBlank()) {
            invalidFields.add("createdBy");
        }

        if (!invalidFields.isEmpty()) {
            return new Result.InvalidData(invalidFields.toArray(new String[0]));
        } else return null;
    }
    private RoomEntity mapToRoomEntity(Command command) {

        return new RoomEntity(command.name(), command.createdBy());
    }
    private UserEntity mapRoomEntityToUserEntity(RoomEntity r) {

        return new UserEntity(r.getCreatedBy(), r.getId());
    }
}


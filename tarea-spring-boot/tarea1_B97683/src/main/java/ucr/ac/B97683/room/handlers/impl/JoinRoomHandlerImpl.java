package ucr.ac.B97683.room.handlers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ucr.ac.B97683.room.handlers.JoinRoomHandler;
import ucr.ac.B97683.room.jpa.entities.UserEntity;
import ucr.ac.B97683.room.jpa.repositories.RoomRepository;
import ucr.ac.B97683.room.jpa.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class JoinRoomHandlerImpl implements JoinRoomHandler {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Override
    public Result joinRoom(Command command) {

        //Validar espacios nulos o en blanco
        Result.InvalidData invalidData = checkInvalidFields(command);
        if(invalidData != null){
            return invalidData;
        }

        //Validar que la sala exista
        var currentRoom = roomRepository.findById(command.roomID());
        if(currentRoom.isEmpty()){
            return null;
        }

        //Validar que el alias sea único
        var currentUser = userRepository.findByAliasAndRoomID(command.alias(), command.roomID());
        if(currentUser.isPresent()){
            return null;
        }

        //Obtener todos los usuarios de la sala
        List<UserEntity> roomUsers = userRepository.findByRoomID(command.roomID());

        //Guardar al usuario en la BD
        var user = mapToUserEntity(command);
        userRepository.save(user);
        roomUsers.add(user);

        return new JoinRoomHandler.Result.Success(
                command.roomID(),
                currentRoom.get().getName(),
                listToUsersArray(roomUsers)
                );
    }

    private JoinRoomHandler.Result.InvalidData checkInvalidFields(JoinRoomHandler.Command command) {
        List<String> invalidFields = new ArrayList<>();

        if (command.alias() == null || command.alias().isBlank()) {
            invalidFields.add("alias");
        }
        if (command.roomID() == null || command.roomID().toString().isBlank()) {
            invalidFields.add("roomID");
        }

        if (!invalidFields.isEmpty()) {
            return new JoinRoomHandler.Result.InvalidData(invalidFields.toArray(new String[0]));
        } else return null;
    }
    private UserEntity mapToUserEntity(JoinRoomHandler.Command command) {

        return new UserEntity(command.alias(), command.roomID());
    }

    private String [] listToUsersArray(List<UserEntity> userList){

        String [] userAlias = new String[userList.size()];

        int i = 0;
        for(UserEntity user :userList) {

            userAlias[i] = user.getAlias();
            i++;
        }

        return userAlias;
    }

}

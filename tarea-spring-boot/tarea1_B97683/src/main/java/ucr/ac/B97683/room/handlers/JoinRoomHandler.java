package ucr.ac.B97683.room.handlers;

import java.util.UUID;

public interface JoinRoomHandler {

    //Formato de la entrada de datos
    record Command(UUID roomID, String alias){}

    //Métodos a implementar en la clase JoinRoomHandlerImpl que determinan la respuesta (salida)
    sealed interface Result{

        //Éxito
        final record Success(UUID id, String name, String [] users) implements JoinRoomHandler.Result {}

        //Datos de entrada inválidos
        final record InvalidData(String... fields) implements JoinRoomHandler.Result {}

    }

    //Método para realizar la acción de unirse a una sala, se implementa en JoinRoomHandlerImpl
    Result joinRoom (Command command);

}

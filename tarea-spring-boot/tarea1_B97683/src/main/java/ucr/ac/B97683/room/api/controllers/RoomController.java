package ucr.ac.B97683.room.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ucr.ac.B97683.room.api.types.JoinResponse;
import ucr.ac.B97683.room.api.types.JoinRoomRequest;
import ucr.ac.B97683.room.api.types.Response;
import ucr.ac.B97683.room.api.types.CreateRoomRequest;
import ucr.ac.B97683.room.handlers.CreateRoomHandler;
import ucr.ac.B97683.room.handlers.JoinRoomHandler;

@RestController
@RequestMapping("api/B97683/room")
public class RoomController {

    @Autowired
    private CreateRoomHandler createHandler;

    @Autowired
    private JoinRoomHandler joinHandler;

    //----------------- POST para crear una sala -----------------\\

    @PostMapping("/create")
    //Response es la clase que da formato a la respuesta
    public Response register(@RequestBody CreateRoomRequest request) {

        var result = createHandler.createRoom(new CreateRoomHandler.Command(
                //El JSON recibido posee estos campos
                request.name(),
                request.createdBy()
        ));
        return switch (result) {
            case CreateRoomHandler.Result.Success success -> new Response(success.message());
            case CreateRoomHandler.Result.InvalidData invalidData -> null;
        };
    }


    //----------------- POST para unirse a una sala -----------------\\

    @PostMapping("/join")
    public JoinResponse join(@RequestBody JoinRoomRequest request) {

        var result = joinHandler.joinRoom(new JoinRoomHandler.Command(
                request.id(),
                request.alias()
        ));

        return switch (result) {
            case JoinRoomHandler.Result.Success success -> new JoinResponse(success.id(), success.name(), success.users());
            case JoinRoomHandler.Result.InvalidData invalidData -> null;
            case null -> null;
        };
    }
}

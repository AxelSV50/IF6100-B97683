package ucr.ac.B97683.room.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucr.ac.B97683.room.api.types.*;
import ucr.ac.B97683.room.handlers.CreateRoomHandler;
import ucr.ac.B97683.room.handlers.JoinRoomHandler;
import ucr.ac.B97683.room.handlers.RoomMessageHandler;

@RestController
@RequestMapping("api/B97683/room")
public class RoomController {

    @Autowired
    private CreateRoomHandler createHandler;

    @Autowired
    private JoinRoomHandler joinHandler;

    @Autowired
    private RoomMessageHandler messagesHandler;

    //----------------- POST para crear una sala -----------------\\

    @PostMapping("/create")
    //Response es la clase que da formato a la respuesta
    public CreateRoomResponse register(@RequestBody CreateRoomRequest request) {

        var result = createHandler.createRoom(new CreateRoomHandler.Command(
                //El JSON recibido posee estos campos
                request.name(),
                request.createdBy()
        ));
        return switch (result) {
            case CreateRoomHandler.Result.Success success -> new CreateRoomResponse(success.message());
            case CreateRoomHandler.Result.InvalidData invalidData -> null;
            case null -> null;
            default -> null;
        };
    }


    //----------------- POST para unirse a una sala -----------------\\

    @PostMapping("/join")
    public JoinRoomResponse join(@RequestBody JoinRoomRequest request) {

        var result = joinHandler.joinRoom(new JoinRoomHandler.Command(
                request.id(),
                request.alias()
        ));

        return switch (result) {
            case JoinRoomHandler.Result.Success success -> new JoinRoomResponse(success.id(), success.name(), success.users());
            case JoinRoomHandler.Result.InvalidData invalidData -> null;
            case null -> null;
            default -> null;
        };
    }


    //----------------- POST para enviar un mensaje a la sala -----------------\\

    @PostMapping("/message")
    public RoomPostMessageResponse sendMessage(@RequestBody RoomPostMessageRequest request) {

        var result = messagesHandler.sendMessage(new RoomMessageHandler.PostMessageCommand(
                request.id(),
                request.alias(),
                request.message()
        ));

        return switch (result) {

            //POST
            case RoomMessageHandler.Result.PostMessageSuccess success -> new RoomPostMessageResponse(success.roomID(), success.createdOn(), success.message());
            case RoomMessageHandler.Result.PostMessageInvalidData invalidData -> null;
            case null -> null;
            default -> null;
        };
    }

    //----------------- GET para obtener todos los mensajes de una sala -----------------\\

    @GetMapping("/message")
    public RoomGetAllMessagesResponse getRoomMessages(@RequestBody RoomPostMessageRequest request) {

        var result = messagesHandler.getAllMessages(new RoomMessageHandler.GetMessagesCommand(
                request.id()
        ));

        return switch (result) {

            //GET
            case RoomMessageHandler.Result.GetMessagesSuccess success -> new RoomGetAllMessagesResponse(success.roomID(), success.name(), success.messages());
            case RoomMessageHandler.Result.GetMessagesInvalidData invalidData -> null;
            case null -> null;
            default -> null;
        };
    }
}

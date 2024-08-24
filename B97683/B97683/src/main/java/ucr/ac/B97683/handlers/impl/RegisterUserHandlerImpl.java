package ucr.ac.B97683.handlers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ucr.ac.B97683.handlers.RegisterUserHandler;
import ucr.ac.B97683.jpa.entities.UserEntity;
import ucr.ac.B97683.jpa.repositories.UserRepository;

import java.util.UUID;

//Etiqueta que define componentes
@Component
public class RegisterUserHandlerImpl implements RegisterUserHandler {

    //Autowired Establece esto como obligatorio
    @Autowired
    private UserRepository repository;

    @Override
    public Result registerUser(Command command) {

        //System.out.println("User has been registered, data: "+command.name()+", "+command.email()+", "+command.password());
        var user = new UserEntity();

        user.setName(command.name());
        user.setEmail(command.email());
        user.setId(UUID.randomUUID());

        repository.save(user);
        return new Result.Success("OK");
    }
}

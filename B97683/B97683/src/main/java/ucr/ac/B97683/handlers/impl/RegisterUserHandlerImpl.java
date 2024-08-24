package ucr.ac.B97683.handlers.impl;

import org.springframework.stereotype.Component;
import ucr.ac.B97683.handlers.RegisterUserHandler;

//Etiqueta que define componentes
@Component
public class RegisterUserHandlerImpl implements RegisterUserHandler {
    @Override
    public Result registerUser(Command command) {

        System.out.println("User has been registered, data: "+command.name()+", "+command.email()+", "+command.password());
        return new Result.Success("Success");
    }
}

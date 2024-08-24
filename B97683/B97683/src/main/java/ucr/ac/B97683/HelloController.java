package ucr.ac.B97683;

//Paquete web obtenido desde la dependencia agregada en Spring Initializer
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ucr.ac.B97683.handlers.RegisterUserHandler;

@RestController
public class HelloController {

    //Etiqueta usada para inyectar dependencias
    @Autowired
    private RegisterUserHandler handler;
    //No tendrá reglas de negocio ningún controlador
    @GetMapping("/hello")
    public String hello() {

        var result =  handler.registerUser(
                new RegisterUserHandler.Command(
                        "Axel",
                        "email@mail.com",
                        "1234"
            )
        );


        return switch (result){
            //Si es de tipo Success
            case RegisterUserHandler.Result.Success success ->
                    success.message();
            case RegisterUserHandler.Result.InvalidData invalidData ->
                    "Invalid data: "+ String.join(", ", invalidData.fields());
        };
        //return "Hello, world!";
    }
}

package ucr.ac.B97683;

//Paquete web obtenido desde la dependencia agregada en Spring Initializer
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, world!";
    }
}

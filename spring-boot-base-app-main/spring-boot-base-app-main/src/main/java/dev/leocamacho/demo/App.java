package dev.leocamacho.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    /*
        Liquidbase es una alternativa para que todos manejen la misma versión de BD en un equipo
        POST es el único que tiene el Payload: Campo para agregar información como JSON, XML, Form...
        TAREA:

        1. PAQUETE API.REST , hacer lo mismo que en RegisterUserController en el proyecto que se está haciendo
    */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

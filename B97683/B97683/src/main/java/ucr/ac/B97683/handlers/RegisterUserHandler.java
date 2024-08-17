package ucr.ac.B97683.handlers;

public interface RegisterUserHandler {

    //Patrón CQRS
    //Record facilita crear componentes de entrada
    record Command(String name, String email, String password){}

    //Limita la cantidad de hijos a tener, se definen directamente. Cuáles son las salidas que va a dar
    sealed interface Result{

        final record Success(String message) implements Result{}

        //Cantidad de parámetros no definida String...
        final record InvalidData(String... fields) implements Result{}
    }
    void registerUser();

}

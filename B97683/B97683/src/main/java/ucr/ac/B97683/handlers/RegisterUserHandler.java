package ucr.ac.B97683.handlers;

public interface RegisterUserHandler {

    //Patrón CQRS
    //Record es una clase que facilita crear componentes de entrada, definimos lo que se va a pedir en la inyección de dependencias
    //De alguna manera estructura la entarda de datos. No puede tener hijos porque es de sólo lectura
    record Command(String name, String email, String password){}

    //Limita la cantidad de hijos a tener, se definen directamente. Cuáles son las salidas que va a dar
    //Interface sellada??
    sealed interface Result{

        final record Success(String message) implements Result{}
        //TODAS LAS VARIABLES DE RECORD SE CONVIERTEN EN MÉTODOS
        //message pasa a ser message() como un get de esa variable

        //Cantidad de parámetros no definida String...
        final record InvalidData(String... fields) implements Result{}
    }

    //Métodos de la interface (Obligatorio implementar en cada clase)
    Result registerUser(Command command);

}

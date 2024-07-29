package ManejoExcepciones.excepeciones;

public class OperacionExcepecion extends RuntimeException{ //Osea de tipo CheckException
    public OperacionExcepecion(String mensaje){
        super(mensaje);
    }
}

package ManejoExcepciones.test;

import ManejoExcepciones.excepeciones.OperacionExcepecion;

import static ManejoExcepciones.aritmetica.Aritmetica.division;

public class TestExcepciones {
    public static void main(String[] args) {
        int resultado = 0;
        try {
            resultado = division(10, 0);

        }catch (OperacionExcepecion e){
            System.out.println("Ocurrio un error de tipo OperacionExpecion");
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("Ocurrió un error de tipo Exception: ");
            //e.printStackTrace(System.out); //--> si queremos mandarle toda la pila del error
            System.out.println(e.getMessage()); //--> mostramos el error que solo necesita ver el usu
        }
        finally { //Este bloque siempre se ejecuta independiente de lo que pase arriba
            System.out.println("Se revisó la división entre cero");//O lo podriamos usar para cerrar algun resurso o base de datos por ej
        }
        System.out.println("resultado = " + resultado);
    }
}

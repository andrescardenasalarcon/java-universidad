package ManejoExcepciones.aritmetica;

import ManejoExcepciones.excepeciones.OperacionExcepecion;

public class Aritmetica {
    public static int division(int numerador, int denominador){
        if (denominador == 0){
            throw new OperacionExcepecion("No se puede dividir entre 0");
        }
        return numerador/denominador;
    }
}

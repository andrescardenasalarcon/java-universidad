package programacion.args_variables;

public class ArgsVariables {
    //Pasar un Argumento hacia un Metodo
    public static void main(String[] args) {
        /*imprimirNumeros(4, 5, 6);
        imprimirNumeros(0, 1);*/
        variosParametros("Andres",1,2,3,4);

    }

    private static void variosParametros(String nombre, int... numeros){
        System.out.println("nombre = " + nombre);
        imprimirNumeros(numeros);

    }
    private static void imprimirNumeros(int... numeros){
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("elementos = " + numeros[i]);
        }
    }
}

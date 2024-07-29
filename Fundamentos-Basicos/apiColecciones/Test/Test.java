package apiColecciones.Test;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        //--------------------LISTAS-------------------
        //Se pueden duplicar los elementos sin  ningun problema
        List miLista = new ArrayList(); //--> Guarda el orden con forme se van agregando
        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");

        for (Object elemento : miLista) {
            //System.out.println("elemento = " + elemento);
        }
        System.out.print('\n');
        //Funcion lamnda o funciones flecha
        miLista.forEach(element -> {
            //System.out.println("element = " + element);
        });

        //------------------SET------------------
        Set miSet = new HashSet(); //No garantiza que mantenga un orden con forme se van a agregando
        //Ventajas: es más rapido gurdar operaciones dentro de un set
        //No se pueden duplicar elementos, en ese caso lo desecha y deja solo uno

        miSet.add("Enero");
        miSet.add("Febrero");
        miSet.add("Marzo");
        miSet.add("Abril");
        miSet.add("Mayo");
        miSet.add("Junio");
        miSet.add("Junio");

    //    imprimir(miSet);

        //-------------------MAP-------------------
        Map miMapa = new HashMap();

        miMapa.put("valor1", "Juan");
        miMapa.put("valor2", "Karla");
        miMapa.put("valor3", "Andrés");

        String elemento = (String) miMapa.get("valor2");
        System.out.println("elemento = " + elemento);

        imprimir(miMapa.keySet()); //--> Devuelve solo el SET de las llaves
        imprimir(miMapa.values()); //--> Imprime cada uno de los valores asociados a nuestas primero a nuestras llaves y luego a los valores args
    }

    public static void imprimir(Collection collection){
        System.out.print('\n');
        collection.forEach(element -> {
            System.out.println("element = " + element);
        });
    }
}

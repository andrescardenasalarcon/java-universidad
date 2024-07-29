package genericaColecciones.test.generica.test;

import genericaColecciones.test.generica.ClaseGenerica;

import java.util.*;

public class TestGenerics {
    public static void main(String[] args) {
        List<String> miLista = new ArrayList<>();
        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");

        String element = miLista.get(1);
        System.out.println("element = " + element);

        //------------------SET------------------
        Set<String> miSet = new HashSet<>();
        miSet.add("Enero");
        miSet.add("Febrero");
        miSet.add("Marzo");
        miSet.add("Abril");
        miSet.add("Mayo");
        miSet.add("Junio");

        imprimir(miSet);

        //-------------------MAP-------------------
        Map<String,String> miMapa = new HashMap();

        miMapa.put("valor1", "Juan");
        miMapa.put("valor2", "Karla");
        miMapa.put("valor3", "Andrés");

        String elemento = miMapa.get("valor2");
        System.out.println("elemento = " + elemento);

        imprimir(miMapa.keySet());
        imprimir(miMapa.values());
    }

    public static void imprimir(Collection<String> collection){
        System.out.print('\n');
        collection.forEach(element -> {
            System.out.println("element = " + element);
        });
    }

}

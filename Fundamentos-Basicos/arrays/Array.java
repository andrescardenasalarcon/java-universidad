package arrays;

import arrays.clases.Person;

public class Array {

    public static void main(String[] args) {
        int edades[] = new int[3];

        System.out.println("edades = " + edades);
        edades[0] = 10;
        System.out.println("edades[0] = " + edades[0]);

        for (int i = 0; i < edades.length; i++) {
            System.out.println("Edades elemento = " + i + " con valor de = " + edades[i]);
        }

        //Arreglo con inicializacion de elementos
        String frutas[] = {"Naranja", "Plantano", "Uva"};
        for (int i = 0; i < frutas.length; i++) {
            System.out.println("frutas = " + frutas[i]);
        }
        //###########Con OBJETOS########
        Person personas[] = new Person[2];
        personas[0] = new Person("Andres");
        personas[1] = new Person("Carlos");
        System.out.println("personas[0] = " + personas[0]);
        System.out.println("personas[1] = " + personas[1]);

        for (int i = 0; i < personas.length; i++) {
            System.out.println("personas i = " + i + " => " + personas[i]);
        }


    }
}

package arrays;

import arrays.clases.Person;

public class Matriz {
    //NOTA: para mover o buscar es xxxx[fila][columna]
    public static void main(String[] args) {
        int edades[][] = new int[3][2];
        edades[0][0] = 5;
        edades[0][1] = 7;
        edades[1][0] = 2;
        edades[1][1] = 4;

        System.out.println("edades = " + edades[0][0]);
        //Para saber el tamaño que tiene las filas y las columnas
        System.out.println("Fila.length= " + edades.length);//FILAS
        System.out.println("Columna.length= " + edades[0].length);//COLUMNAS
        //------------------------------------------------


        for (int fil = 0; fil < edades.length; fil++) {
            for (int col = 0; col < edades[fil].length; col++) {
                System.out.println("edades = " + edades[fil][col] + ", fila= " + fil + ", columna= " + col);

            }

        }

        String frutas[][] = {{"Naranja", "Mandarina"}, {"Fresa", "Mora"}};
        for (int i = 0; i < frutas.length; i++) {
            for (int j = 0; j < frutas[i].length; j++) {
                System.out.println("frutas [" + i + "][" + j + "]= " + frutas[i][j]);
            }

        }
        System.out.println("-------------------------------------------");
        //###########Con OBJETOS########
        Person personas[][] = new Person[2][3];
        personas[0][0] = new Person("Andres");
        personas[0][1] = new Person("Carlos");
        imprimir(personas);

    }
    public static void imprimir(Object matriz[][]){
        for (int fil = 0; fil < matriz.length; fil++) {
            for (int col = 0; col < matriz[fil].length; col++) {
                System.out.println("matriz [" + fil + "][" + col + "]= " + matriz[fil][col]);

            }
        }
    }

}

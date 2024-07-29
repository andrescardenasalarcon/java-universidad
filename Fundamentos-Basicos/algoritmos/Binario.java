package algoritmos;
// Java implementation of QuickSort
import java.io.*;

public class Binario {

    private int binarySearch(int arreglo[], int x) {
        int left = 0;
        int right = arreglo.length - 1;

        while (left <= right) {
            int mediana = (right + left) / 2;
            System.out.println(mediana);
            //Revisa si x es la mediana
            if (arreglo[mediana] == x)
                return mediana;

            //Si x es mas grande, ignora la izq e incrementa a left
            if (arreglo[mediana] < x)
                left = mediana + 1;

                //Si x es menor, ignora la der, y decrementa la der
            else
                right = mediana - 1;
        }

        //Elemento no presente en el arreglo
        return -1;
    }

    public static void main(String[] args) {
        Binario ob = new Binario();
        int arreglo[] = {1, 2, 3, 4, 5, 6, 7};

        int find = 6;
        int rta = ob.binarySearch(arreglo, find);
        if (rta == -1) {
            System.out.println("Elemento no presente");
        } else {
            for (int i = rta; i < arreglo[rta]; i++) {
                System.out.println("Numero de index {" + rta + "} --> " + arreglo[i]);
            }

        }
    }
}

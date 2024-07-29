package algoritmos;

public class QuickSort {

    //Funcion para cambiar dos elementos
    static void cambio(int[] arreglo, int a, int b) {
        int temp = arreglo[a];
        arreglo[a] = arreglo[b];
        arreglo[b] = temp;
    }

    //Toma el ultimo elemeneto como el pivote
    //los demas numero los ordena de mas pequeño a la izq del pivote
    //y todos los mas grandes a la derecha del pivote
    static int dividir(int[] arreglo, int menor, int mayor) {

        //Escoge el pivote "que es #num del final del arreglo"
        int pivote = arreglo[mayor];

        //Indice mas pequeño, dado por #num mas pequeño
        int i = (menor - 1);

        for (int j = menor; j <= mayor - 1; j++) {

            if (arreglo[j] < pivote) {

                //Incrementando el indice del num mas pequeño
                i++;
                cambio(arreglo, i, j);
            }
        }
        cambio(arreglo, i + 1, mayor);
        return (i + 1);
    }

    static void quickSort(int[] arreglo, int menor, int mayor) {
        if (menor < mayor) {

            //fraccionando el indice, a la nueva posicion
            int pi = dividir(arreglo, menor, mayor);

            // Ordene los elementos por separado antes
            // de la partición y después de la partición
            quickSort(arreglo, menor, pi - 1);
            quickSort(arreglo, pi + 1, mayor);
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    public static void main(String[] args) {
        int[] arreglito = { 10, 7, 8, 9, 1, 5 };
        int N = arreglito.length;

        quickSort(arreglito, 0, N - 1);
        System.out.println("Sorted array: ");
        printArr(arreglito);
    }

}

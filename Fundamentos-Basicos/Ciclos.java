import java.util.Arrays;

public class Ciclos {
    public static void main(String[] args) {
        /*-------------WHILE------------*/
        /*var contador = 0;
        while (contador < 3){ //agregamos un watch seleccionando la condicion contador < 3
            System.out.println("contador = " + contador);
            contador++;
        } */ //Ctrl+Mayús+/ (para comentar un bloque).

        /*-------------DO-WHILE------------*/
        //Ejecuta almenos una vez el cod sin importar la validación
        /*var contador = 0;
        do {
            System.out.println("contador = " + contador);
            contador++;

        }while (contador < 0);*/

        /*-------------FOR y BRAKE------------*/
        /*for ( var contador = 0; contador < 3 ; contador++)
        {
            if (contador % 2 == 0) {
                System.out.println("contador = " + contador);
                break;
            }
        }*/
        /*-------------FOR y CONTINUE------------*/
        for ( var contador = 0; contador < 3 ; contador++)
        {
            if (contador % 2 != 0) {
                continue; // ir a la sig iteracion
            }
            System.out.println("contador = " + contador);
        }
        /*-------------ETIQUETAS------------*///NO ES RECOMENDADO
        inicio:
        for ( var contador = 0; contador < 3 ; contador++)
        {
            if (contador % 2 != 0) {
                continue inicio; // ir a al cod de la etiqueta inicio  --SE USARIA PARA SALTAR DE UN FOR A OTRO FOR O CODIGO EN ESPECIFICO (FOR ANIDADOS)
            }
            System.out.println("contador = " + contador);
        }



    }
}

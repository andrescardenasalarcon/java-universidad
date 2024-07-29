public class Igualdad_Relaciones {
    public static void main(String[] args) {
        var a = 3;
        var b = 2;

        var c = (a == b);
        System.out.println("c = " + c);

        var d = (a != b);
        System.out.println("d = " + d);

        var cadena1 = "Hola";
        var cadena2 = "Hola";
        var e = cadena1 == cadena2; //Compara la referencia en memoria del contenido
        System.out.println("e = " + e);

        var f = cadena1.endsWith(cadena2);//Comparamos contenido de cadenas
        System.out.println("f = " + f);

        /*------------------Operadores Relacionales-----------------------*/
        
        var g = a > b; //mayor que > o mayor igual >=
        System.out.println("g = " + g);

        if (a % 2 == 0) {
            System.out.println("Es  numero par");
        }else{
            System.out.println("Es numero impar");
        }

        /*---------------Estructura switch----------------*/
        var numero = 2;
        var numeroTexto = "Valor desconocido";
        switch (numero){
            case 1:
                numeroTexto = "Numero uno";
                break;
            case 2:
                numeroTexto = "Número dos";
                break;
            case 3:
                numeroTexto = "Numero tres";
                break;
            default:
                numeroTexto = "Caso no encontrado";
        }
        System.out.println("numeroTexto = " + numeroTexto);

    }
}

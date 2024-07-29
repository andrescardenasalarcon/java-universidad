public class Variables {
    public static void main(String[] args) {
        //Numca Definir varibales con numeros o caracteres especiales
        //valores permitidos en  nuestras varibales
        var miVariable = 1;
        var _miVariable = 2;
        var $miVariable = 3;


        //Cadenas y concatenacion
        var usu = "Juna";
        var titulo = "Ingeniero";

        var union = titulo+" "+ usu;
        System.out.println("Union = "+ union);

        var i = 3;
        var j = 4;

        System.out.println(i + j); //Se realiza la suma
        System.out.println(i + j + usu);
        System.out.println(usu + i + j); //Contexto cadena, todo lo toma como una cadena
        System.out.println(usu + (i + j)); //Le da prioridad a los parentesis y liego vuelve a evaluar a contexto cadena

    }

}

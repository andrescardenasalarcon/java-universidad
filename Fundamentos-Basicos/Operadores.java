public class Operadores {
    public static void main(String[] args) {
        int a=3, b=2;
        var resultado = a + b;
        System.out.println("resultado = " + resultado);
        
        resultado = a - b;
        System.out.println("resultado = " + resultado);
        
        resultado = a * b;
        System.out.println("resultado = " + resultado);

        var resultado2 = 3D / b;
        System.out.println("resultado = " + resultado2);

        resultado = a % b;
        System.out.println("resultado2 = " + resultado);

        if (a % 2 == 0){
            System.out.println("Numero par");
        }else{
            System.out.println("Numero Impar");
        }

    }
}

package clase.sobreCargaMetodos;

public class Operaciones {

    public static int sumar(int a, int b){
        return a + b;
    }
    public static double sumar(double a, double b){
        return a + b;
    }

    public static void main(String[] args) {
        var rta = sumar(3, 2);
        System.out.println("rta = " + rta);
        var rta2 = sumar(3.0,2.0);
        System.out.println("rta = " + rta2);
    }
}

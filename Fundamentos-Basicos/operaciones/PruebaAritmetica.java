package operaciones;

public class PruebaAritmetica {
    public static void main(String[] args) {
        Aritmetica aritmetica1 = new Aritmetica();
        aritmetica1.a = 3;
        aritmetica1.b = 2;

        aritmetica1.sumar();
        int rta = aritmetica1.sumarReturn();
        System.out.println("rta = " + rta);

        rta = aritmetica1.sumarConArgs(3,2);
        System.out.println("rta2 = " + rta);
        
        Aritmetica aritmetica2 = new Aritmetica(8,5);
        System.out.println("aritmetica2.a= " + aritmetica2.a);
        System.out.println("aritmetica2.b = " + aritmetica2.b);
        aritmetica2.sumar();


    }
}

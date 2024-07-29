public class Composicion {
    public static void main(String[] args) {
        int a = 3;

        a += 1; // a = a + 1
        System.out.println("a = " + a);

        a += 3; //a = a + 3
        System.out.println("a = " + a);

        a -= 2; //a = a - 2
        System.out.println("a = " + a);

        // *=        /=       %=


        //---------Operadores Unarios--------------
        System.out.println("---------Operadores Unarios--------------");
        var b = -a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        //Operador de negacion "boolean"
        var c = true;
        var d = !c;
        System.out.println("c = " + c);
        System.out.println("d = " + d);

        //Incremento
        System.out.println("--Incremento--");
        //1. preincremento (simbolo antes de la variable)
        var e = 3;
        var f = ++e; //primero se incrementa la variable e cambiando de valor y luego se asigna el valor a f
        System.out.println("e = " + e);
        System.out.println("f = " + f);

        //2.postincremento (simbolo despues de la variable)
        var g = 5;
        var h = g++;//primero se utiliza la variable en h y luego se incrementa en g
        System.out.println("g = " + g);
        System.out.println("h = " + h);
        System.out.println("--Decremento--");
        //Decremento
        //1.pre
        var i = 2;
        var j = --i;
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        //2. post
        var k = 4;
        var l = k--;
        System.out.println("k = " + k);
        System.out.println("l = " + l);


    }
}

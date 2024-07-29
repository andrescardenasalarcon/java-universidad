package clase.herencia.test;

import clase.herencia.domain.Cliente;
import clase.herencia.domain.Empleado;

import java.time.LocalDate;
import java.util.Date;

public class Inheritance {
    public static void main(String[] args) {
        Empleado em1 = new Empleado("Andres",2000.0);
        System.out.println("em1 = " + em1);

        var fecha = new Date();

        Cliente cli1 = new Cliente("Andres",'M',21,"FALSA123",fecha,false);
        System.out.println("cli1 = " + cli1);
    }
}

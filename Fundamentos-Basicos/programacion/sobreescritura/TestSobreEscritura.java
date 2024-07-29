package programacion.sobreescritura;

public class TestSobreEscritura {
    public static void main(String[] args) {

//        PILIMORFISMO  --> MÚLTIPLES COMPORTAMIENTOS

        Empleado empleado = new Empleado("Juan", 5000);
        //System.out.println("Empleado= " + empleado.obtenerDetalles());
        imprimir(empleado);

        empleado = new Gerente("Andres", 2000, "TI");
        //System.out.println(gerente.obtenerDetalles());
        imprimir(empleado);

    }

    public static void imprimir(Empleado empleado){
        System.out.println("empleado = " + empleado.obtenerDetalles());

    }
}

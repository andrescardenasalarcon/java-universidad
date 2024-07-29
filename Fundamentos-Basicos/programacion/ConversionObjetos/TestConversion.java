package programacion.ConversionObjetos;

public class TestConversion {
    public static void main(String[] args) {
        Empleado empleado;

        empleado = new Escritor("Andres", 5000,TipoEscritura.CLASICO);
        //System.out.println("empleado = " + empleado);

        System.out.println(empleado.obtenerDetalles());
        //empleado.getTipoEscritura(); //No lo podemos llamar ya que no es común entre la clase Escritor y empleado
        //Para solucionar esto hacemos un DownCasting
        /*----Conversion de Obj------*/

        //((Escritor)empleado).getTipoEscritura();
        Escritor escritor = (Escritor) empleado;
        System.out.println(escritor.getTipoEscritura());

        //UpCasting  --> no es necesario hacer una conversion explicita
        Empleado empleado1 = escritor;
        System.out.println(empleado1.obtenerDetalles());

    }
}

package programacion.ClaseObject;

public class TestConversion {
    public static void main(String[] args) {
         Empleado empleado = new Empleado("Andres", 5000);
         Empleado empleado1 = new Empleado("Andres", 5000);

         //Como saber si estos dos obj son iguales
        if (empleado == empleado1) {
            System.out.println("Tienen la misma ref en memoria");
        }
        else {
            System.out.println("Tienen distinta ref en memoria");
        }
        //Preguntamos mediante el contenido --> equals and hashCode()
        var rta = empleado.equals(empleado1);
        if (rta){
            System.out.println("Los obj son iguales en contenido");
        }else {
            System.out.println("Los obj No son iguales en contenido");
        }
        //Preguntamos mediante un valor entero de nuestro contenido
        if (empleado.hashCode() == empleado1.hashCode()){
            System.out.println("El valor hashcode es igual, emp= "+empleado.hashCode()+", emp1= "+empleado1.hashCode());
        }
        else {
            System.out.println("El valor hashcode es distinto, emp= "+empleado.hashCode()+", emp1= "+empleado1.hashCode());
        }

    }
}

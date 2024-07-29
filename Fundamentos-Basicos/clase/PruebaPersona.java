package clase;

public class PruebaPersona {
    public static void main(String[] args) {
        Persona personas = new Persona();
        personas.setNombre("Andres");
        personas.setApellido("Cárdenas");
        personas.desplegarInfo();

        Persona personas2 = new Persona("Andres","Felipe",2000.0,false);
        Persona personas3 = new Persona("Andres","Felipe",2000.0,false);
        System.out.println("personas2 = " + personas2);

        personas2.desplegarInfo();

        System.out.println(personas2.toString());
        System.out.println(personas3);

//        var rows = 8;
//        for (var i = 0; i<=rows-1;i++){
//            for (int j=0;j<=i;j++){
//                System.out.print(".");
//            }
//            for (int k=0;k<=rows-1-i;k++){
//                System.out.print("*"+" ");
//            }
//            System.out.println();
//        }
    }

}

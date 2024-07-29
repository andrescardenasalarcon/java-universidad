package modificadores_de_acceso.test;

import modificadores_de_acceso.paquete_protected.ClassHija;
import modificadores_de_acceso.publico.Class1;

public class TestModificadoresAcceso {
    public static void main(String[] args) {
        Class1 clase1 = new Class1(); //Cuando es publica la podemos llamar desde cualquier otra clase
        System.out.println("clase1 = " + clase1.atributoPublico);
        clase1.metodoPublico();

        /*----------------Protected---------------*/
//        Al estar nuestra class1 en otro paquete y de tipo protected esta ya no la podemos usar o llamar a manera de clase
//        No podemos llamar el contructor de manera protected -- creamos y hacemos uso de uno public
        modificadores_de_acceso.protegido.Class1 clase2 = new modificadores_de_acceso.protegido.Class1("Publico");
       /* System.out.println("clase2 = " + clase2.atributoProtected());
        clase2.metodoProtected();*/
//        De manera que usamos el extends o herencia para poder llamar a nuestra clase ver en ClassHija
        System.out.println("-----------------Protected--------------");
        ClassHija classHija = new ClassHija();
        System.out.println("claseHija = "+ classHija );
    }
}

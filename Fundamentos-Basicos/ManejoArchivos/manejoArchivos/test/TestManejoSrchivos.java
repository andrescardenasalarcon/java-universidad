package ManejoArchivos.manejoArchivos.test;

import static ManejoArchivos.manejoArchivos.ManejoArchivos.*;

public class TestManejoSrchivos {
    public static void main(String[] args) {
        var nombreArchivo = "C:\\Users\\Andres\\Documents\\Varios\\Curso-Java-Cero-Master\\ManejoArchivos\\prueba.txt";
        //crearArchivos(nombreArchivo);

        //escribirArchivo(nombreArchivo, "Hola desde Java"); //--> Sobre escribe la información
//        anexarArchivo(nombreArchivo,"Hola desde Java");
//        anexarArchivo(nombreArchivo,"Adiós");

        //-----------Leer infromación------
        leerArchivo(nombreArchivo);
    }
}

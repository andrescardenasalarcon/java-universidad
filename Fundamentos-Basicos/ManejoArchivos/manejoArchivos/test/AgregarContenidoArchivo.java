package ManejoArchivos.manejoArchivos.test;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class AgregarContenidoArchivo {

    public static void main(String[] args) {
        boolean anexado = false;

        var nombreArchivo = "C:\\Users\\Andres\\Documents\\Varios\\Curso-Java-Cero-Master\\ManejoArchivos\\prueba.txt";
        var archivo = new File(nombreArchivo);
        try {
            //Revisar si existe
            anexado = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexado));
            var nuevoContenido = "Nuevo \nContenido";
            salida.println(nuevoContenido);
            salida.close();
            System.out.println("Se agregó contenido al archivo");
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

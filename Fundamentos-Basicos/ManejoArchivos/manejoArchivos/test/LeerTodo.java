package ManejoArchivos.manejoArchivos.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LeerTodo {
    public static void main(String[] args) {
        var nombreArchivo = "C:\\Users\\Andres\\Documents\\Varios\\Curso-Java-Cero-Master\\ManejoArchivos\\prueba.txt";

        try {
            List<String> lineas = Files.readAllLines(Paths.get(nombreArchivo));
            System.out.println("Contenido del archivo: ");
//            for (String linea : lineas) {
//                System.out.println(linea);
//            }
            lineas.forEach(System.out::println);


        } catch (IOException e) {
            System.out.println("Error al leer el archivo" + e.getMessage());
            e.printStackTrace();
        }

    }
}

package LaboratiorioPeliculas.co.com.peliculas.presentacion;

import LaboratiorioPeliculas.co.com.peliculas.servicios.CatalogoPeliculasImpl;
import LaboratiorioPeliculas.co.com.peliculas.servicios.ICatalogoPeliculas;

import java.util.Scanner;

public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) {
        var opcion = -1;
        Scanner scanner = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();

        while (opcion != 0) {
            System.out.println("Elige una opcion: \n" +
                    "1. Iniciar catalogo de peliculas \n" +
                    "2. Agrergar pelicula \n" +
                    "3. Listar peliculas \n" +
                    "4. Buscar pelicula\n" +
                    "0. Salir");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula: ");
                    var nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Introduce el nombre de una pelicula ");
                    var buscar = scanner.nextLine();
                    catalogo.buscarPeliculas(buscar);
                    break;
                case 0:
                    System.out.print("Hasta pronto!!!");
                    break;
                default:
                    System.out.print("Opcion no reconocida");
                    break;
            }
        }
    }
}

package LaboratorioPeliculasXMi.view;


import LaboratorioPeliculasXMi.rest.CatalogoMovie;
import LaboratorioPeliculasXMi.service.movies.ICatalogoMovies;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainPeliculas {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int inputKb = -1;
        ICatalogoMovies catalogo = new CatalogoMovie();

        Map<Integer, Runnable> actions = new HashMap<>();

        actions.put(1, () -> catalogo.startCatalogoMovies());
        actions.put(2, () -> {
            System.out.println("Input a name movie: ");
            catalogo.addMovie(kb.nextLine());
        });
        actions.put(3, () -> catalogo.listMovies());
        actions.put(4, () -> {
            System.out.println("Introduce el nombre de la pelicula: ");
            catalogo.searchMovie(kb.nextLine());
        });
        actions.put(0, () -> System.out.println("EXIT!!!"));

        while (inputKb != 0) {
            System.out.println("Elige una opcion: \n" +
                    "1. Iniciar catalogo de peliculas \n" +
                    "2. Agrergar pelicula \n" +
                    "3. Listar peliculas \n" +
                    "4. Buscar pelicula\n" +
                    "0. Salir");
            inputKb = Integer.parseInt(kb.nextLine());

            Runnable action = actions.get(inputKb);

            if (action != null) {
                action.run();
            } else {
                System.out.println("Opcion no registrada!!!\n");
            }
        }

    }
}

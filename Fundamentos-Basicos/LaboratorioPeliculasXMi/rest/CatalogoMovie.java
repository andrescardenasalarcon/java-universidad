package LaboratorioPeliculasXMi.rest;

import LaboratorioPeliculasXMi.exceptions.AccessDataEx;
import LaboratorioPeliculasXMi.exceptions.ReadDataEx;
import LaboratorioPeliculasXMi.model.Movie;
import LaboratorioPeliculasXMi.service.data.IAccessData;
import LaboratorioPeliculasXMi.service.movies.ICatalogoMovies;

import java.util.List;

public class CatalogoMovie implements ICatalogoMovies {

    protected IAccessData data;

    public CatalogoMovie() {
        this.data = new AccessData();
    }

    @Override
    public void addMovie(String nameMovie) {
        Movie newMovie = new Movie(nameMovie);
        boolean anexo = false;
        try {
            anexo = this.data.exist(NAME_FILE);
            this.data.write(newMovie, NAME_FILE, anexo);
        } catch (AccessDataEx e) {
            e.printStackTrace();
            System.out.println("Error to access data");
        }
    }

    @Override
    public void listMovies() {
        try {
            List<Movie> movies = this.data.list(NAME_FILE);
            movies.forEach(movie -> {
                System.out.println("movie = " + movie);
            });
        } catch (ReadDataEx e) {
            e.printStackTrace();
            System.out.println("Error to acces data");
        }
    }

    @Override
    public void searchMovie(String search) {
        String result = "No se encontró dicha pelicula.";
        try {
            result = this.data.search(NAME_FILE, search);
        } catch (ReadDataEx e) {
            e.printStackTrace();
        }
        System.out.println("result = " + result);
    }

    @Override
    public void startCatalogoMovies() {
        try {
            if (this.data.exist(NAME_FILE)) {
                this.data.delete(NAME_FILE);
                this.data.create(NAME_FILE);
            } else {
                this.data.create(NAME_FILE);
            }
        } catch (AccessDataEx e) {
            e.printStackTrace();
            System.out.println("Error to start Catalogo of Movies");
        }
    }
}

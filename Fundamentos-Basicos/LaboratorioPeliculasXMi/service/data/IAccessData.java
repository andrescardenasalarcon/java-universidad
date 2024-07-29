package LaboratorioPeliculasXMi.service.data;

import LaboratorioPeliculasXMi.exceptions.AccessDataEx;
import LaboratorioPeliculasXMi.exceptions.ReadDataEx;
import LaboratorioPeliculasXMi.exceptions.WriteDataEx;
import LaboratorioPeliculasXMi.model.Movie;

import java.util.List;

public interface IAccessData {

    boolean exist(String nameFile) throws AccessDataEx;

    List<Movie> list(String nameFile) throws ReadDataEx;

    void write(Movie movie, String nameFile, boolean anexar) throws WriteDataEx;

    String search(String nameFile, String searchMovie) throws ReadDataEx;

    void create(String nameFile) throws AccessDataEx;

    void delete(String nameFile) throws AccessDataEx;

}

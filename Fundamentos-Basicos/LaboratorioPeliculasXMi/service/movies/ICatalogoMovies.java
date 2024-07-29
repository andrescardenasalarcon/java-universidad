package LaboratorioPeliculasXMi.service.movies;

public interface ICatalogoMovies {
    final String NAME_FILE = "C:\\Users\\Andres\\Documents\\Varios\\Curso-Java-Cero-Master\\LaboratorioPeliculasXMi\\movies.txt";

    void addMovie(String nameMovie);

    void listMovies();

    void searchMovie(String search);

    void startCatalogoMovies();

}

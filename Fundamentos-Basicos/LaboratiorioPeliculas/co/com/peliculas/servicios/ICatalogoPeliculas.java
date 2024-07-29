package LaboratiorioPeliculas.co.com.peliculas.servicios;

public interface ICatalogoPeliculas {
    String NOMBRE_RECURSO = "C:\\Users\\Andres\\Documents\\Varios\\Curso-Java-Cero-Master\\LaboratiorioPeliculas\\peliculas.txt";

    void agregarPelicula(String nombrePelicula);

    void listarPeliculas();

    void buscarPeliculas(String buscar);

    void iniciarCatalogoPeliculas();
}

package LaboratiorioPeliculas.co.com.peliculas.datos;

import LaboratiorioPeliculas.co.com.peliculas.domain.Pelicula;
import LaboratiorioPeliculas.co.com.peliculas.excepciones.AccesoDatosEx;
import LaboratiorioPeliculas.co.com.peliculas.excepciones.EscrituraDatosEx;
import LaboratiorioPeliculas.co.com.peliculas.excepciones.LecturaDatosEx;

import java.util.List;

public interface IAccesoDatos {

    boolean existe(String nombreRecurso) throws AccesoDatosEx;

    List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;

    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;

    void crear(String nombreRecurso) throws AccesoDatosEx;

    void borrar(String nombreRecurso) throws AccesoDatosEx;

}

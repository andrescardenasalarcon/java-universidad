package LaboratiorioPeliculas.co.com.peliculas.servicios;

import LaboratiorioPeliculas.co.com.peliculas.datos.AccesoDatosImpl;
import LaboratiorioPeliculas.co.com.peliculas.datos.IAccesoDatos;
import LaboratiorioPeliculas.co.com.peliculas.domain.Pelicula;
import LaboratiorioPeliculas.co.com.peliculas.excepciones.AccesoDatosEx;
import LaboratiorioPeliculas.co.com.peliculas.excepciones.LecturaDatosEx;

import java.util.List;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas{

    private final IAccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = this.datos.existe(NOMBRE_RECURSO);
            this.datos.escribir(pelicula,NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx e) {
            System.out.println("Error de acceso a datos");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            List<Pelicula> peliculas = this.datos.listar(NOMBRE_RECURSO);
            peliculas.forEach(pelicula -> {
                System.out.println("pelicula = " + pelicula);
            });
        } catch (LecturaDatosEx e) {
            System.out.println("Error de acceso datos");
            e.printStackTrace();
        }
    }

    @Override
    public void buscarPeliculas(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (AccesoDatosEx e) {
            e.printStackTrace();
            System.out.println("Error de acceso datos");
            e.printStackTrace();
        }
        System.out.println("resultado = " + resultado);
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {

            if (this.datos.existe(NOMBRE_RECURSO)) {
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            } else {
                datos.crear(NOMBRE_RECURSO);
            }
        }catch (AccesoDatosEx ex){
            System.out.println("Error al iniciar catalogo de peliculas");
            ex.printStackTrace();
        }
    }
}

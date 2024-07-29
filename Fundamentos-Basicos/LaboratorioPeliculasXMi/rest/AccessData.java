package LaboratorioPeliculasXMi.rest;

import LaboratorioPeliculasXMi.exceptions.AccessDataEx;
import LaboratorioPeliculasXMi.exceptions.ReadDataEx;
import LaboratorioPeliculasXMi.exceptions.WriteDataEx;
import LaboratorioPeliculasXMi.model.Movie;
import LaboratorioPeliculasXMi.service.data.IAccessData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccessData implements IAccessData {


    @Override
    public boolean exist(String nameFile) throws AccessDataEx {
        File file = new File(nameFile);
        return file.exists();
    }

    @Override
    public List<Movie> list(String nameFile) throws ReadDataEx {
        File file = new File(nameFile);
        List<Movie> movieList = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(file));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                Movie newMovie = new Movie(linea);
                movieList.add(newMovie);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ReadDataEx("Exception to list movies: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movieList;
    }

    @Override
    public void write(Movie movie, String nameFile, boolean anexar) throws WriteDataEx {
        File file = new File(nameFile);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(file, anexar));
            salida.println(movie);
            salida.close();
            System.out.println("Write the movie at file successufly = " + nameFile);
        } catch (IOException e) {
            e.printStackTrace();
            throw new WriteDataEx("Exceotion to write movie: " + e.getMessage());
        }
    }

    @Override
    public String search(String nameFile, String searchMovie) throws ReadDataEx {
        File file = new File(nameFile);
        String result = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(file));
            String linea = null;
            linea = entrada.readLine();
            int index = 1;
            while (linea != null) {
                if (searchMovie != null && searchMovie.equalsIgnoreCase(linea)) {
                    result = "Movie " + linea + " found with index " + index;
                    break;
                }
                linea = entrada.readLine();
                index++;
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ReadDataEx("Exception to search movie" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new ReadDataEx("Exception to search movie" + e.getMessage());
        }
        return result;
    }

    @Override
    public void create(String nameFile) throws AccessDataEx {
        File file = new File(nameFile);
        try {
            PrintWriter salida = new PrintWriter(file);
            salida.close();
            System.out.println(" File create to save movie " + nameFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new AccessDataEx("Excepetion to create file " + e.getMessage());
        }
    }

    @Override
    public void delete(String nameFile) throws AccessDataEx {
        File file = new File(nameFile);
        if (file.exists()) {
            file.delete();

        }
        System.out.println("File delete for movies");
    }
}

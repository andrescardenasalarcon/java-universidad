package com.afca.maquina_snacks_archivos.servicio;

import com.afca.maquina_snacks_archivos.modelo.Snack;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SnacksServicioArchivos implements ISnacksServicio {

    private final String NOMBRE_ARCHIVO = "sancks.txt";
    //Crear la lista de snacks
    private List<Snack> snacks = new ArrayList<>();

    //Contructor clase
    public SnacksServicioArchivos() {
        //Creamos el archivo si no existe
        var archivo = new File(NOMBRE_ARCHIVO);
        var existe = false;
        try {
            existe = archivo.exists();
            if (existe) {
                this.snacks = obtenerSnacks();
            } else {
                //Creamos el archivo
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo");
            }
        } catch (Exception e) {
            System.out.println("Error al crer el archivo: " + e.getMessage());
        }
        //Si no existe, cargamos algunos snacks iniciales
        if (!existe) cargarSnacksIniciales();
    }

    private void cargarSnacksIniciales() {
        this.agregarSnack(new Snack("Papas", 1700));
        this.agregarSnack(new Snack("Refresco", 5000));
        this.agregarSnack(new Snack("Sandwich", 2400));
    }

    private List<Snack> obtenerSnacks() {
        var snacks = new ArrayList<Snack>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));
            for (String linea : lineas) {
                String[] lineaSnack = linea.split(",");//Parseo separado por comas
                var idSnack = lineaSnack[0]; //No se usa el index
                var nombre = lineaSnack[1];
                var precio = Double.parseDouble(lineaSnack[2]);
                var snack = new Snack(nombre, precio);
                snacks.add(snack);//Agregamos a la lista en local que tenemos para este metodo
            }

        } catch (Exception e) {
            System.out.println("Error al leer archivo de snacks: " + e.getMessage());
            e.printStackTrace();
        }
        return snacks;
    }

    @Override
    public void agregarSnack(Snack snack) {
        //Agregamos el nuevo snack
        //1. A la lista en memoria
        this.snacks.add(snack);
        //2. Guardamos el nuevo snack en el archivo
        this.agregarSnackArchivo(snack);
    }

    private void agregarSnackArchivo(Snack snack) {
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            anexar = archivo.exists();
            if (anexar) {
                var salida = new PrintWriter(new FileWriter(archivo, anexar));
                salida.println(snack.escribirSnack());
                salida.close();
            }
        } catch (Exception e) {
            System.out.println("Error al agregar el archivo: " + e.getMessage());
        }
    }

    @Override
    public void mostrarSnacks() {
        System.out.println("----Snacks en el Inventario----");
        //Mostramos la lista de snacks en el inventario
        var inventarioSnacks = "";
        for (Snack snack : this.snacks) {
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println(inventarioSnacks);
    }

    @Override
    public List<Snack> getSnacks() {
        return this.snacks;
    }
}

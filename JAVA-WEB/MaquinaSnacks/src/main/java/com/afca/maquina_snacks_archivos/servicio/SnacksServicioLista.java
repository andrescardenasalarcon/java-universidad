package com.afca.maquina_snacks_archivos.servicio;

import com.afca.maquina_snacks_archivos.modelo.Snack;

import java.util.ArrayList;
import java.util.List;

public class SnacksServicioLista implements ISnacksServicio{

    private static final List<Snack> snacks;

    // Bloque static inicializador
    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Cheeps", 2000));
        snacks.add(new Snack("Coke", 3000));
        snacks.add(new Snack("Sandwich", 3500));

    }

    public void agregarSnack(Snack snack) {
        snacks.add(snack);
    }

    public void mostrarSnacks() {
        var inventarioSnacks = "";
        for (var snack : snacks) {
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println("---------Snack en el Inventario---------");
        System.out.println(inventarioSnacks);
    }

    public List<Snack> getSnacks() {
        return snacks;
    }

}

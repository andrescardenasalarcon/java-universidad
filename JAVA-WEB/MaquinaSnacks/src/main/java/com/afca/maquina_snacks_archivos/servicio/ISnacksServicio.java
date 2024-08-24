package com.afca.maquina_snacks_archivos.servicio;

import com.afca.maquina_snacks_archivos.modelo.Snack;

import java.util.List;

public interface ISnacksServicio {
    void agregarSnack(Snack snack);

    void mostrarSnacks();

    List<Snack> getSnacks();
}

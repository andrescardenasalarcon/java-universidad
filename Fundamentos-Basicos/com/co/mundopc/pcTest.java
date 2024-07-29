package com.co.mundopc;

public class pcTest {
    public static void main(String[] args) {
        Monitor monitorHP = new Monitor("HP", 13.0);
        Teclado tecladoHP = new Teclado("USB", "HP");
        Raton ratonHP = new Raton("Bluetooth", "HP");

        Computadora computadora1 = new Computadora("Pc Hp", monitorHP, ratonHP, tecladoHP);

        Monitor monitorGamer = new Monitor("Gamer", 34.0);
        Teclado tecladoGamer = new Teclado("USB", "Gamer");
        Raton ratonGamer = new Raton("Bluetooth", "Gamer");

        Computadora computadora2 = new Computadora("Pc Gamer", monitorGamer, ratonGamer, tecladoGamer);
        Orden orden = new Orden();
        orden.agregarComputadora(computadora1);
        orden.agregarComputadora(computadora2);

        orden.MostrarOrden();



    }
}

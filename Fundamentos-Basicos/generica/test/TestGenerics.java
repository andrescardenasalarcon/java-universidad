package generica.test;

import generica.ClaseGenerica;

public class TestGenerics {
    public static void main(String[] args) {
        ClaseGenerica<Integer> objInt = new ClaseGenerica(1);
        objInt.obtenerTipo();

        ClaseGenerica<String> objStr = new ClaseGenerica("Andres");
        objStr.obtenerTipo();
    }
}

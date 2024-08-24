package com.afca.maquina_snacks_archivos.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Snack implements Serializable {

    private static int contadorSnacks = 0;
    private int idSnack;
    private String snackName;
    private double price;

    public Snack() {
        this.idSnack = ++Snack.contadorSnacks;
    }

    public Snack(String snackName, double price) {
        this(); //--> así hacemos llamar al contrcutor vacio
        this.snackName = snackName;
        this.price = price;
    }

    public static int getContadorSnacks() {
        return contadorSnacks;
    }


    public int getIdSnack() {
        return idSnack;
    }


    public String getSnackName() {
        return snackName;
    }

    public void setSnackName(String snackName) {
        this.snackName = snackName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "idSnack=" + idSnack +
                ", snackName='" + snackName + '\'' +
                ", price=" + price +
                '}';
    }

    public String escribirSnack() {
        return this.idSnack + "," + this.snackName + "," + this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Snack snack)) return false;
        return getIdSnack() == snack.getIdSnack() && Double.compare(getPrice(), snack.getPrice()) == 0 && Objects.equals(getSnackName(), snack.getSnackName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdSnack(), getSnackName(), getPrice());
    }
}

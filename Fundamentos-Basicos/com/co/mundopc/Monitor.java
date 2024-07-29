package com.co.mundopc;

public class Monitor {
    private final int idMonitor;
    private String marca;
    private Double tamanno;
    private static int contadorMonitores;

    private Monitor(){
        this.idMonitor = ++Monitor.contadorMonitores;
    }
    public Monitor(String marca, Double tamanno){
        this();
        this.marca = marca;
        this.tamanno = tamanno;
    }

    public int getIdMonitor() {
        return idMonitor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getTamanno() {
        return tamanno;
    }

    public void setTamanno(Double tamanno) {
        this.tamanno = tamanno;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "idMonitor=" + idMonitor +
                ", marca='" + marca + '\'' +
                ", tamanno=" + tamanno +
                '}';
    }
}

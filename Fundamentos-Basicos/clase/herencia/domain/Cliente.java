package clase.herencia.domain;

import java.util.Date;

public class Cliente extends Person{
    private int idCliente;
    private Date fechaRefistro;
    private boolean vip;
    private static int contadorCliente;


    public Cliente() {
    }

    public Cliente(String nombre, char genero, int edad, String direccion, Date fechaRefistro, boolean vip) {
        super(nombre, genero, edad, direccion);
        this.idCliente = ++contadorCliente;
        this.fechaRefistro = fechaRefistro;
        this.vip = vip;
    }

    public int getIdCliente() {
        return idCliente;
    }


    public static int getContadorCliente() {
        return contadorCliente;
    }

    public static void setContadorCliente(int contadorCliente) {
        Cliente.contadorCliente = contadorCliente;
    }

    public Date getFechaRefistro() {
        return fechaRefistro;
    }

    public void setFechaRefistro(Date fechaRefistro) {
        this.fechaRefistro = fechaRefistro;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                ", idCliente="+ idCliente+
                ", fechaRefistro=" + fechaRefistro +
                ", vip=" + vip +
                ", "+super.toString()+
                '}';
    }
}

package talleres;

public class main {
    public static void main(String[] args) {
        Caja caja = new Caja();
        caja.setAncho(3);
        caja.setAlto(2);
        caja.setProfundo(6);
        var rta = caja.volumen();
        System.out.println("rta = " + rta);


    }
}

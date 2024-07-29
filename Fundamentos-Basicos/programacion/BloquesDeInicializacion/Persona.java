package programacion.BloquesDeInicializacion;

public class Persona {
    //Tenenmos 2 staticos y no estaticos
    private final int idPersona; //no statico
    private static int contadorPersonas; //  statico

    //Bloque de codigo de inicializacion statico -- se ejecuta antes del constructor -- no permite a los no estaticos
    //Este solo se ejecuta 1 vez, a penas se cargue en memoria
    static {
        System.out.println("Ejecución bloque estatico");
        ++Persona.contadorPersonas;
    }

    //Bloque de inicializacion no estatico -- antes del contructor de nuestra class
    //Se ejecuta cada vez que creemos un obj de nuestra clase
    //Se le conoce como contexto dinamico
    {
        System.out.println("Ejecucion de bloque NO estatico");
        this.idPersona = Persona.contadorPersonas++;
    }
    public Persona(){
        System.out.println("Ejecucion del constructor");
    }

    public int getIdPersona() {
        return idPersona;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "idPersona=" + idPersona +
                '}';
    }
}

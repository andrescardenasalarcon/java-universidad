package clase;

public class Persona {
    private int idPersona;
    private static int contador;
    private String nombre;
    private String apellido;
    private double sueldo;
    private boolean eliminado;

    public Persona() {
    }

    public Persona(String nombre, String apellido, double sueldo, boolean eliminado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
        this.eliminado = eliminado;
        this.idPersona = ++Persona.contador;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getSueldo() {
        return this.sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public boolean isEliminado() {
        return this.eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public void desplegarInfo() {
        System.out.println(String.format("Persona: %s %s", getNombre(), getApellido()));//https://codigofacilito.com/articulos/format-string-java
    }

    @Override
    public String toString() {
        return "Persona{" +
                "idPersona=" + idPersona +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", sueldo=" + sueldo +
                ", eliminado=" + eliminado +
                '}';
    }
}

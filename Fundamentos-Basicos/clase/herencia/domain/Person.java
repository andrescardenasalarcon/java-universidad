package clase.herencia.domain;

public class Person {
    //El protected es ideal cuando vamos a tener que hacer que estos campos los herede otra clase,
    // esto permite que se pueda acceder desde la clase heredada a los campos de aquí,
    // sin necesidad de usar el getXxx si no como this.xxx
    //Tambien es valido hacer el llamado con el getXxx pero lo comun es así ya que por eso es lo del protected
    protected String nombre;
    protected char genero;
    protected int edad;
    protected String direccion;

    public Person() {
    }

    public Person(String nombre) {
        this.nombre = nombre;
    }

    public Person(String nombre, char genero, int edad, String direccion) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Person{" +
                "nombre='" + nombre + '\'' +
                ", genero=" + genero +
                ", edad=" + edad +
                ", direccion='" + direccion + '\'' +
                ", memoria= "+super.toString()+
                '}';
    }
}

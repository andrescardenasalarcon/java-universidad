package clase.herencia.domain;

public class Empleado extends Person{
    private int idEmpleado;
    private double sueldo;
    private static int contadorEmpleado;

    public Empleado(){
        idEmpleado = ++Empleado.contadorEmpleado;
    }

    public Empleado(String nombre, double sueldo) {
        //super(nombre);
        // se coloca this y dento de los () los campos del contructor a llamar "en este caso niguno para el llamado del contructor vacio"
        this();//Se escoge entre super o el construcotr vacio, esto por jerarquias
        //Aqui vamos a inicializar los atributos de nuestra clase padre (por esto dejamos el protected)
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append("Empleado{idEmpleado=").append(this.idEmpleado);
       sb.append(", sueldo=").append(this.sueldo);
       sb.append(",").append(super.toString());
       sb.append("}");
       return sb.toString();
    }
}

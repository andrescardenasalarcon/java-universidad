package accesodatos;

public interface IAccesoDatos {
    //public static final int MAX_REGISTROS = 10; --> de manera automatica así se veria los atributos
    int MAX_REGISTROS = 10;

    //public abstract void insertar(); --> asi se veria este metodo
    void insertar();

    void listar();

    void actualizar();

    void elmininar();
}

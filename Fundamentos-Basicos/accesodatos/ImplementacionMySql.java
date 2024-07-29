package accesodatos;

public class ImplementacionMySql implements IAccesoDatos{


    @Override
    public void insertar() {
        System.out.println("Insertar desde MySql");
    }

    @Override
    public void listar() {
        System.out.println("Listar dede MySql");
    }

    @Override
    public void actualizar() {
        System.out.println("Actualizar desde MySql");
    }

    @Override
    public void elmininar() {
        System.out.println("Eliminar desde Mysql");
    }
}

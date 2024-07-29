package accesodatos.test;

import accesodatos.*;

public class TestInterfaces {

    public static void main(String[] args) {
        IAccesoDatos mySql = new ImplementacionMySql();
        imprimir(mySql);
    }

    public static void imprimir(IAccesoDatos data){
        data.listar();
    }

}

import java.sql.*;
import java.util.Arrays;

public class TestMySqlJDBC {
    public static void main(String[] args) {
        //jdbc:mysql://[HOST-IP]:3306/[BD-NAME]?useSSL=false&serverTimezone=UTC
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";

        try {
//            Class.forName("com.mysql.cj.jdbc.Driver"); //En app web podria ser NECESARIA
            Connection conexion = DriverManager.getConnection(url, "root", "admin");

            //Objeto de tipo statement
            Statement instruccion = conexion.createStatement();
            String sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona;";
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()) { //Inidica si tenemos algun elemento a Iterar, devuelve True si tiene más, False cierra el ciclo.
                //Tambien se puede por idices de la "Sql" iniciando desde 1, 2, ...
                System.out.print("Id Persona: " + resultado.getInt("id_persona"));
                System.out.print(" Nombre: " + resultado.getString("nombre"));
                System.out.print(" Apellido: " + resultado.getString("apellido"));
                System.out.print(" Email: " + resultado.getString("email"));
                System.out.print(" Telefono: " + resultado.getString("telefono"));
                System.out.println();
            }
            //------------Cerrar los procesos--De manera manual-------------
            resultado.close();
            instruccion.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

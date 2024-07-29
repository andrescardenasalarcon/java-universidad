import daos.IPersonaDao;
import daos.PersonaDAO;
import datos.Conexion;
import model.PersonaDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ManejoPersonas {
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false); //Neceitamos que la conexion no haga autocommit
            }

            IPersonaDao personaDAO = new PersonaDAO(conexion);

            List<PersonaDTO> personas = personaDAO.seleccionar();

            personas.forEach(persona -> {
                System.out.println("persona = " + persona);
            });

            conexion.commit();
            System.out.println("Se ha hecho el commit de la transaccion");

        } catch (SQLException e) {
            System.out.println("Entramos al rollback");
            e.printStackTrace();
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}

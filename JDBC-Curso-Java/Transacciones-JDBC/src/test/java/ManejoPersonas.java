import daos.PersonaDAO;
import datos.Conexion;
import model.Persona;

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

            PersonaDAO personaDAO = new PersonaDAO(conexion);

            Persona personaModificar = new Persona();
            personaModificar.setIdPersona(2);
            personaModificar.setNombre("Elizabeth");
            personaModificar.setApellido("Alarcón");
            personaModificar.setEmail("elizeth@gmail.com");
            personaModificar.setTelefono("3142625883");
            personaDAO.actualizar(personaModificar);

            Persona persona = new Persona("test", "test", "test@gmail.com", "1111111");
            personaDAO.insertar(persona);

            conexion.commit(); //Hasta este momento se haran los cambios en la bd. y no los haga de manera autormatica
            listPersona(personaDAO);
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

    static void listPersona(PersonaDAO personaDAO) {
        List<Persona> personList = null;
        try {
            personList = personaDAO.seleccionar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        personList.forEach(person -> {
            System.out.println(person);
        });
    }
}

import daos.PersonaDAO;
import model.Persona;

import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();

        //Insertando un nuevo obj de tipo persona
//        Persona persona = new Persona("Elizabeth", "Alarcón", "elizeth@gmail.com", "3142625883");
//        personaDAO.insertar(persona);
//
//        listPersona(personaDAO);

        //Acualizar una persona
        Persona personaModificar = new Persona(4, "Lis", "Alarcón", "elizeth@gmail.com", "3142625883");
        personaDAO.actualizar(personaModificar);

        //Eliminar una persona

        Persona personaEliminar = new Persona(5);
        personaDAO.eliminar(personaEliminar);

        listPersona(personaDAO);

    }

    static void listPersona(PersonaDAO personaDAO) {
        List<Persona> personList = personaDAO.seleccionar();
        personList.forEach(person -> {
            System.out.println(person);
        });
    }
}

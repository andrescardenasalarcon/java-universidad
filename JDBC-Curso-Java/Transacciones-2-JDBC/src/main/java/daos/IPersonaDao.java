package daos;

import model.PersonaDTO;

import java.sql.SQLException;
import java.util.List;

public interface IPersonaDao {

    //DTO --> DATA TRANSFER OBJECT
    public List<PersonaDTO> seleccionar() throws SQLException;

    public int insertar(PersonaDTO persona) throws SQLException;

    public int actualizar(PersonaDTO persona) throws SQLException;

    public int eliminar(PersonaDTO persona) throws SQLException;
}

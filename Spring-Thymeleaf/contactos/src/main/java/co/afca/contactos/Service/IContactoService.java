package co.afca.contactos.Service;

import co.afca.contactos.model.Contacto;

import java.util.List;

public interface IContactoService {
    public List<Contacto> listarContactos();

    public Contacto buscarContactoPorId(Integer idContacto);

    public void guardarContacto(Contacto contacto);

    public void eliminarContacto(Contacto idContacto);
}

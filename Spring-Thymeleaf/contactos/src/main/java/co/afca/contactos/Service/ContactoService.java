package co.afca.contactos.Service;

import co.afca.contactos.model.Contacto;
import co.afca.contactos.repository.IContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoService implements IContactoService {

    @Autowired
    private IContactoRepository contactoRepository;

    @Override
    public List<Contacto> listarContactos() {
        return this.contactoRepository.findAll();
    }

    @Override
    public Contacto buscarContactoPorId(Integer idContacto) {
        Contacto contacto = this.contactoRepository.findById(idContacto).orElse(null);
        return contacto;
    }

    @Override
    public void guardarContacto(Contacto contacto) {
        this.contactoRepository.save(contacto);
    }

    @Override
    public void eliminarContacto(Contacto idContacto) {
        this.contactoRepository.delete(idContacto);
    }
}

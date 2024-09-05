package co.afca.contactos.repository;

import co.afca.contactos.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContactoRepository extends JpaRepository<Contacto, Integer> {
}

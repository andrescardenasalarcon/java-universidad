package co.afca.contactos.controller;

import co.afca.contactos.Service.ContactoService;
import co.afca.contactos.model.Contacto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContactoController {

    private static final Logger logger = LoggerFactory.getLogger(ContactoController.class);

    @Autowired
    private ContactoService contactoService;

    @GetMapping("/")
    public String iniciar(ModelMap modelo) {
        List<Contacto> contactos = contactoService.listarContactos();
        contactos.forEach((contacto) -> logger.info(contacto.toString()));
        modelo.put("contactos", contactos);
        return "index"; //index.html
    }

    @GetMapping("/agregar")
    public String mostrarAgregar() {
        return "agregar"; //agregar.html
    }

    @PostMapping("/agregar")
    public String agregar(@ModelAttribute("contactoForma") Contacto contacto) {
        logger.info("Contacto a agregar: " + contacto.toString());
        contactoService.guardarContacto(contacto);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable(value = "id") int idContacto, ModelMap modelo) {
        Contacto contacto = contactoService.buscarContactoPorId(idContacto);
        logger.info("Contacto a editar (mostrar): " + contacto);
        modelo.put("contactoEditar", contacto);
        return "editar"; //editar.html
    }

    @PostMapping("/editar")
    public String editar(@ModelAttribute("contactoEditar") Contacto contacto) {
        logger.info("Contacto a guardar: " + contacto);
        contactoService.guardarContacto(contacto);
        return "redirect:/";//index.html --> path="/"
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") int idContacto) {
        Contacto contacto = contactoService.buscarContactoPorId(idContacto);
        contactoService.eliminarContacto(contacto);
        return "redirect:/";
    }
}

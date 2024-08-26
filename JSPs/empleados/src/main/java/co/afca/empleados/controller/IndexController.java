package co.afca.empleados.controller;

import co.afca.empleados.model.Empleado;
import co.afca.empleados.service.EmpleadoService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    EmpleadoService empleadoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String inicar(ModelMap modelo) {
        List<Empleado> empleados = empleadoService.listarEmpleados();
        empleados.forEach(empleado -> logger.info(empleado.toString()));
        //Compartimos el modelo con la vista
        modelo.put("empleados", empleados);
        return "index"; //index.jsp
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.GET)
    public String mostrarAgregar() {
        return "agregar"; //agregar.jsp
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public String agregar(@ModelAttribute("empleadoForma") Empleado empleado, HttpServletRequest request) {
        logger.info("Empleado a agregar: " + empleado);
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/";//redirige al path "/"
    }

    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public String mostrarEditar(@RequestParam int idEmpleado, ModelMap modelo) {
        Empleado empleado = empleadoService.buscarEmpleadoPorIr(idEmpleado);
        logger.info("Empleado a editar: " + empleado);
        modelo.put("empleado", empleado);
        return "editar"; //mostrar la pag de editar.jsp
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editar(@ModelAttribute("empleadoForma") Empleado empleado) {
        logger.info("Empleado a editar: " + empleado);
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/";
    }

    @RequestMapping(value = "/eliminar", method = RequestMethod.GET)
    public String eliminar(@RequestParam int idEmpleado) {
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(idEmpleado);
        empleadoService.eliminarEmpleado(empleado);
        return "redirect:/";
    }
}

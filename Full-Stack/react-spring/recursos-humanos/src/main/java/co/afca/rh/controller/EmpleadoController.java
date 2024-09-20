package co.afca.rh.controller;

import co.afca.rh.exception.RecursoNoEncontrado;
import co.afca.rh.model.Empleado;
import co.afca.rh.service.EmpleadoService;
import co.afca.rh.service.IEmpleadoService;
import org.antlr.v4.runtime.RecognitionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("rh-app")
@CrossOrigin(value = "http://localhost:3000")
public class EmpleadoController {
    private static final Logger logger = LoggerFactory.getLogger(EmpleadoController.class);

    @Autowired
    private IEmpleadoService empleadoService;

    @GetMapping("/empleados")
    public List<Empleado> listarEmpleados() {
        List<Empleado> empleados = empleadoService.listarEmpleados();
        empleados.forEach(empleado -> logger.info(empleado.toString()));
        return empleados;
    }

    @PostMapping("/empleados")
    public ResponseEntity<Empleado> agregarEmpleado(@RequestBody Empleado empleado) {
        logger.info("Empleado a agregado: " + empleado);
        Empleado empreadoTemp = empleadoService.guardarEmpleado(empleado);
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(empreadoTemp);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> buscarEmpleadoPorId(@PathVariable Integer id) {
        Empleado empleado = empleadoService.buscarEmpleado(id);
        if (empleado == null) {
            throw new RecursoNoEncontrado("No se encontró el empleado id: " + id);
        }
        return ResponseEntity.ok(empleado);
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> modificarEmpleado(@PathVariable Integer id, @RequestBody Empleado empledoRecibido) {
        Empleado empleado = empleadoService.buscarEmpleado(id);
        if (empleado == null) {
            throw new RecursoNoEncontrado("El id del recibido no existe: " + id);
        }
        empleado.setNombre(empledoRecibido.getNombre());
        empleado.setDepartamento(empledoRecibido.getDepartamento());
        empleado.setSueldo(empledoRecibido.getSueldo());
        empleadoService.guardarEmpleado(empleado);
        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarEmpleados(@PathVariable Integer id) {
        Empleado empleado = empleadoService.buscarEmpleado(id);
        if (empleado == null) {
            throw new RecursoNoEncontrado("El id del recibido no existe: " + id);
        }
        empleadoService.eliminarEmpleado(empleado);
        //Respuesta
        //Json {"eliminado": "true"}
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);

    }
}

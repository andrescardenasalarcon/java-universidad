package co.afca.empleados.service;

import co.afca.empleados.model.Empleado;
import co.afca.empleados.repository.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    @Override
    public List<Empleado> listarEmpleados() {
        return this.empleadoRepositorio.findAll();
    }

    @Override
    public Empleado buscarEmpleadoPorIr(Integer idEmpleado) {

        Empleado empleado = empleadoRepositorio.findById(idEmpleado).orElse(null);
        return empleado;
    }

    @Override
    public void guardarEmpleado(Empleado empleado) {
        empleadoRepositorio.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        empleadoRepositorio.delete(empleado);
    }
}

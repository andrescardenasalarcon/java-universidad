package co.afca.rh.service;

import co.afca.rh.model.Empleado;
import co.afca.rh.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> listarEmpleados() {
        return this.empleadoRepository.findAll();
    }

    @Override
    public Empleado buscarEmpleado(Integer id) {
        Empleado empleado = this.empleadoRepository.findById(id).orElse(null);
        return empleado;
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return this.empleadoRepository.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        this.empleadoRepository.delete(empleado);
    }
}

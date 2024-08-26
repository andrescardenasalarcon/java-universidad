package co.afca.empleados.service;

import co.afca.empleados.model.Empleado;

import java.util.List;

public interface IEmpleadoService {
    public List<Empleado> listarEmpleados();

    public Empleado buscarEmpleadoPorIr(Integer idEmpleado);

    public void guardarEmpleado(Empleado empleado);

    public void eliminarEmpleado(Empleado empleado);
}

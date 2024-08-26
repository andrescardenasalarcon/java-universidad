package co.afca.empleados.repository;

import co.afca.empleados.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {
}

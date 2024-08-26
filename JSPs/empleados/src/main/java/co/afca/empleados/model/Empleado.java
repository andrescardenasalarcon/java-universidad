package co.afca.empleados.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpleado;
    private String nombre;
    private String departamento;
    private Double sueldo;

}
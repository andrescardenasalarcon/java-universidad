package com.zona_fit.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Entity
@Data //CON ESTA NOTACION NO ENCARGAMOS DE GENERAR LOS METODOS GET Y SET DE NUESTRA CLASE --< GRACIAS A ESTA LIB
@NoArgsConstructor //CONSTRUCTOR VACIO
@AllArgsConstructor //CONSTRUCTOR CON TODOS LOS VALORES
@ToString
@EqualsAndHashCode
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Esto es por que es una PK de manea auto incremente
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer membresia;
}

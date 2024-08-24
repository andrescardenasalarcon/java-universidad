package com.zona_fit.repository;

import com.zona_fit.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
//                                                      Tipo del modelo y el tipo de la llave primaria del mismo
public interface ClienteRespositories extends JpaRepository<Cliente, Integer> {

}

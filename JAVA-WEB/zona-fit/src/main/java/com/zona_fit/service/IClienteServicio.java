package com.zona_fit.service;

import com.zona_fit.models.Cliente;

import java.util.List;

public interface IClienteServicio{
    public List<Cliente> listarClientes();

    public Cliente buscarClientePorId(Integer id);

    public void guardarCliente(Cliente cliente); //Se encargará de crear o actualizar un cliente dependiendo si hay id, id=null --> nuevo id=!null actualiza

    public void eliminarCliente(Cliente cliente);
}

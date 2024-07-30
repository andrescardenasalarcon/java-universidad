package com.zona_fit.service;

import com.zona_fit.models.Cliente;
import com.zona_fit.repository.ClienteRespositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio implements IClienteServicio {
    @Autowired //Auto inyectar un referencia en este caso de la clase Repositorio Cliente
    private ClienteRespositories clienteRespositorio;

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = clienteRespositorio.findAll();
        return clientes;
    }

    @Override
    public Cliente buscarClientePorId(Integer idCliente) {
        //Si encientra el cliente lo devuelve, de lo contrario devuelve null .orElse(null)
        Cliente cliente = clienteRespositorio.findById(idCliente).orElse(null);
        return cliente;
    }

    @Override
    public void guardarCliente(Cliente cliente) {
        clienteRespositorio.save(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clienteRespositorio.delete(cliente);
    }
}

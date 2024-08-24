package com.zona_fit.controlador;

import com.zona_fit.models.Cliente;
import com.zona_fit.service.IClienteServicio;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data //Get-Set
@ViewScoped
//Es una solo una pag que se va a refresacar de manera parcial AJAX -> Asyn Js and XML, en lo que se esta usando esta vista, disponible la info durante el tiempo de vida de lo que se muestra
public class IndexControlador {

    @Autowired
    IClienteServicio clienteServicio;

    private List<Cliente> clientes;
    private Cliente clienteSeleccionado;
    private static final Logger logger = LoggerFactory.getLogger(IndexControlador.class); //Vitacora de infomracion para mostrar en la consola

    @PostConstruct //Crea un constructor que se va a llamar despues de instanciar esta calse
    public void init() {
        cargarDatos();
    }

    public void cargarDatos() {
        this.clientes = clienteServicio.listarClientes();
        this.clientes.forEach(cliente -> logger.info(cliente.toString()));
    }

    public void agregarCliente() {
        this.clienteSeleccionado = new Cliente();
    }

    public void guardarCliente() {
        logger.info("Cliente a guardar: " + this.clienteSeleccionado);
        //Agregar
        if (this.clienteSeleccionado.getId() == null) {
            this.clienteServicio.guardarCliente(this.clienteSeleccionado);
            this.clientes.add(this.clienteSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente Agregado Correctamente"));
        }
        //Modifica (update)
        else {
            this.clienteServicio.guardarCliente(this.clienteSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente Actualizado Correctamente"));
        }
        //Ocultar la ventana modal
        PrimeFaces.current().executeScript("PF('ventanaModalCliente').hide()");
        //Actualizar la tabla usando ajax
        PrimeFaces.current().ajax().update("forma-clientes:mensajes", "forma-clientes:clientes-tabla");
        //Reset del objeto cliente seleccionado
        this.clienteSeleccionado = null;
    }

    public void eliminarCliente() {
        logger.info("Cliente a eliminar: " + this.clienteSeleccionado);
        this.clienteServicio.eliminarCliente(this.clienteSeleccionado);
        //Eliminar el registro de la lista de clientes en memoria
        this.clientes.remove(this.clienteSeleccionado);
        //Reset del obj cliente seleccionado
        this.clienteSeleccionado = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente eliminado Correctamente"));
        PrimeFaces.current().ajax().update("forma-clientes:mensajes", "forma-clientes:clientes-tabla");
    }

}

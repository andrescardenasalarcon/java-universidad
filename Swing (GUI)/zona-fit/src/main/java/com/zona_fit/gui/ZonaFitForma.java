package com.zona_fit.gui;

import com.zona_fit.models.Cliente;
import com.zona_fit.service.ClienteServicio;
import com.zona_fit.service.IClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class ZonaFitForma extends JFrame {
    private JPanel panelPrincipal;
    private JTable clientesTabla;
    private JTextField nombreTexto;
    private JTextField apellidoTexto;
    private JTextField membresiaTexto;
    private JButton guardarButton;
    private JButton eliminarButton;
    private JButton limpiarButton;
    IClienteServicio clienteServicio;
    private DefaultTableModel tableModelClientes;
    private Integer idCliente; //idCliente por default es null

    //Para inyectar la info de la bd justo con la creación del panel
    // de loc ontrario si lo hacemos en el IClienteServicio @Autowired se van a hacer los llamados antes y habria que hacer otra logica
    @Autowired
    public ZonaFitForma(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
        iniciarForma();
        guardarButton.addActionListener(e -> guardarCliente());
        clientesTabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cargarClienteSeleccionado();
            }
        });
        eliminarButton.addActionListener(e -> eliminarCliente());
        limpiarButton.addActionListener(e -> limpiarFormulario());
    }

    private void iniciarForma() {
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
    }


    //casilla "custom create" marcada en ZonaFitForma para la Tabla
    //para asignar las columnas especificas que necesitamos
    private void createUIComponents() {
        // TODO: place custom component creation code here
//        this.tableModelClientes = new DefaultTableModel(0, 4);
        //Evitamos la edición de los valores de las celdas de la tabla
        this.tableModelClientes = new DefaultTableModel(0, 4) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String[] cabeceros = {"id", "Nombre", "Apellido", "Membresia"};
        tableModelClientes.setColumnIdentifiers(cabeceros);
        this.clientesTabla = new JTable(tableModelClientes);
        //Restringimos la seleccion de la tabla a un solo registro
        clientesTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Cargar el listado de clientes
        listarClientes();
    }

    private void listarClientes() {
        this.tableModelClientes.setRowCount(0);
        var clientes = this.clienteServicio.listarClientes();
        clientes.forEach(cliente -> {
            Object[] rengloCliente = {
                    cliente.getId(),
                    cliente.getNombre(),
                    cliente.getApellido(),
                    cliente.getMembresia()
            };
            this.tableModelClientes.addRow(rengloCliente);
        });
    }

    private void guardarCliente() {
        if (nombreTexto.getText().equals("")) {
            mostrarMensaje("Proporciona un nombre");
            nombreTexto.requestFocusInWindow();
            return; //retornamos a la ventana para que tome el valor
        }
        if (membresiaTexto.getText().equals("") || !membresiaTexto.getText().matches("/^([0-9])*$/")) {
            mostrarMensaje("Proporciona un membresia valida");
            membresiaTexto.requestFocusInWindow();
            return; //retornamos a la ventana para que tome el valor
        }
        //Recuperamos los valores del formulario
        var nombre = nombreTexto.getText();
        var apellido = apellidoTexto.getText();
        var membresia = Integer.parseInt(membresiaTexto.getText());
        var cliente = new Cliente(this.idCliente, nombre, apellido, membresia);
        this.clienteServicio.guardarCliente(cliente);
        if (this.idCliente == null) {
            mostrarMensaje("Se agregó el nuevo Cliente");
        } else {
            mostrarMensaje("Se actualizó el Cliente");
        }
        limpiarFormulario();
        listarClientes();
    }

    private void cargarClienteSeleccionado() {
        var renglonSeleccionado = clientesTabla.getSelectedRow(); //Devuelve -1 si no se seleccionó nada
        if (renglonSeleccionado != -1) {
            var id = clientesTabla.getModel().getValueAt(renglonSeleccionado, 0).toString(); //que es el index de la colimna 0 --> id, 1 --> nombre, 2 --> apellido, 3 --> membresia
            this.idCliente = Integer.parseInt(id);
            var nombre = clientesTabla.getModel().getValueAt(renglonSeleccionado, 1).toString();
            this.nombreTexto.setText(nombre);
            var apellido = clientesTabla.getModel().getValueAt(renglonSeleccionado, 2).toString();
            this.apellidoTexto.setText(apellido);
            var membresia = clientesTabla.getModel().getValueAt(renglonSeleccionado, 3).toString();
            this.membresiaTexto.setText(membresia);
        }
    }

    private void eliminarCliente() {
        var renglonSeleccionado = clientesTabla.getSelectedRow();
        if (renglonSeleccionado != -1) {
            var idClienteStr = clientesTabla.getModel().getValueAt(renglonSeleccionado, 0).toString();
            this.idCliente = Integer.parseInt(idClienteStr);
            var clienteEliminar = new Cliente();
            clienteEliminar.setId(this.idCliente);
            clienteServicio.eliminarCliente(clienteEliminar);
            mostrarMensaje("Cliente con id " + this.idCliente + " eliminado");
            limpiarFormulario();
            listarClientes();
        } else {
            mostrarMensaje("Seleccione un cliente a eliminar");
        }
    }

    private void limpiarFormulario() {
        nombreTexto.setText("");
        apellidoTexto.setText("");
        membresiaTexto.setText("");
        //Limpiamos el id del cliente seleccionado
        this.idCliente = null;
        //Deseleccionamos el registro seleccionado de la tabla
        this.clientesTabla.getSelectionModel().clearSelection();
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}

package zona_fit.data;

import zona_fit.Conexion.Conexion;
import zona_fit.models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static zona_fit.Conexion.Conexion.getConnection;

public class ClienteDAO implements IClienteDAO {

    @Override
    public List<Cliente> listarClientes() {
        var clientes = new ArrayList<Cliente>();
        PreparedStatement ps;
        ResultSet rs;
        Connection conexion = getConnection();
        var sql = "SELECT * FROM cliente ORDER BY id";
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                clientes.add(cliente);
            }

        } catch (Exception e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conexion.close();


            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }

        }
        return clientes;
    }

    @Override
    public boolean buscarClientePorId(Cliente cliente) {
        PreparedStatement ps;
        ResultSet rs;
        Connection conexion = getConnection();
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar cliente: " + e.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection conexion = getConnection();
        String sql = "INSERT INTO cliente (nombre, apellido, membresia) VALUES (?, ?, ?)";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getMembresia());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Error al agregar cliente: " + e.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }

        return false;
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection conexion = getConnection();
        var sql = "UPDATE cliente SET nombre = ?, apellido = ?, membresia = ? WHERE id = ?";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getMembresia());
            ps.setInt(4, cliente.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al modificar cliente: " + e.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection conexion = getConnection();
        String sql = "DELETE FROM cliente WHERE id = ?";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println("*** Listar Clientes ***");
//        IClienteDAO clienteDao = new ClienteDAO();
//        var clientes = clienteDao.listarClientes();
//        clientes.forEach(cliente -> System.out.println(cliente));

        //Buscar por id
//        var cliente1 = new Cliente(1);
//        System.out.println("Cliente antes de la busqueda: " + cliente1);
//        var clienteDAO = new ClienteDAO();
//        var ecnontrado = clienteDAO.buscarClientePorId(cliente1);
//        if (ecnontrado) {
//            System.out.println("Cliente encontrado: " + cliente1);
//        } else {
//            System.out.println("Cliente no encontrado: " + cliente1);
//        }

        //Agregar cliente
//        var nuevoCliente = new Cliente("Maria", "Alarcon", 150);
//        var clienteDAO = new ClienteDAO();
//        var agregado = clienteDAO.agregarCliente(nuevoCliente);
//        if (agregado) {
//            System.out.println("Cliente agregado: " + nuevoCliente);
//        } else {
//            System.out.println("Cliente no agregado: " + nuevoCliente);
//        }

        //Actualizar Cliente
//        var modificarCliente = new Cliente(2, "María", "Alarcón", 150);
//        IClienteDAO clienteDao = new ClienteDAO();
//        var modificado = clienteDao.modificarCliente(modificarCliente);
//        if (modificado) {
//            System.out.println("Cliente modificado: " + modificarCliente);
//        } else {
//            System.out.println("No se modificó el cliente: " + modificarCliente);
//        }

        //Eliminar cliente
//        var clienteEliminar = new Cliente(5);
//        IClienteDAO clienteDao = new ClienteDAO();
//        var econtrado = clienteDao.buscarClientePorId(clienteEliminar);
//        if (econtrado) {
//            var eliminado = clienteDao.eliminarCliente(clienteEliminar);
//            if (eliminado) {
//                System.out.println("Cliente eliminado: " + clienteEliminar);
//            } else {
//                System.out.println("Cliente no eliminado: " + clienteEliminar);
//            }
//        } else {
//            System.out.println("Cliente no encontrado: " + clienteEliminar);
//        }
//
//
//        System.out.println("*** Listar Clientes ***");
//        var clientes = clienteDao.listarClientes();
//        clientes.forEach(System.out::println);

    }
}

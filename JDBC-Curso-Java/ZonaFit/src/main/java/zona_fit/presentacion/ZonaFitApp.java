package zona_fit.presentacion;

import zona_fit.data.ClienteDAO;
import zona_fit.data.IClienteDAO;
import zona_fit.models.Cliente;

import java.util.Scanner;

public class ZonaFitApp {
    public static void main(String[] args) {
        zonaFitApp();
    }

    private static void zonaFitApp() {
        var salir = false;
        var consola = new Scanner(System.in);

        IClienteDAO clienteDAO = new ClienteDAO();
        while (!salir) {
            try {
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(consola, opcion, clienteDAO);
            } catch (Exception e) {
                System.out.println("Error el ajecutar opciones: " + e.getMessage());
            }
            System.out.println();
        }

    }

    private static int mostrarMenu(Scanner consola) {
        System.out.println("""
                *** Zona Fit (GYM)
                1. Listar Clientes
                2. Buscar Cliente
                3. Agregar Cliente
                4. Modificar Cliente
                5. Eliminar Cliente
                6. Salir
                Elije una opcion:\s""");
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(Scanner consola, int opcion, IClienteDAO clienteDAO) {
        var salir = false;
        switch (opcion) {
            case 1 -> {
                System.out.println("---Listado de Clientes---");
                var clientes = clienteDAO.listarClientes();
                clientes.forEach(System.out::println);
            }
            case 2 -> {
                System.out.print("Introduce el id del Cliente a buscar: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                var cliente = new Cliente(idCliente);
                var encontrado = clienteDAO.buscarClientePorId(cliente);
                if (encontrado) {
                    System.out.println("Cliente encontrado: " + cliente);
                } else {
                    System.out.println("Cliente NO encontrado: " + cliente);
                }
            }
            case 3 -> {
                System.out.println("--- Agregar Cliente ---");
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Membresia: ");
                var membresia = Integer.parseInt(consola.nextLine());
                var cliente = new Cliente(nombre, apellido, membresia);
                var agregado = clienteDAO.agregarCliente(cliente);
                if (agregado) {
                    System.out.println("Cliente agregado: " + cliente);
                } else {
                    System.out.println("Cliente NO agregado: " + cliente);
                }
            }
            case 4 -> {
                System.out.println("--- Modificar Cliente ---");
                System.out.println("ID Cliente a modificar");
                var idCliente = Integer.parseInt(consola.nextLine());
                var cliente = new Cliente(idCliente);
                var encontrado = clienteDAO.buscarClientePorId(cliente);
                if (!encontrado) {
                    System.out.println("Cliente NO encontrado: " + cliente);
                    break;
                }
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Membresia: ");
                var membresia = Integer.parseInt(consola.nextLine());
                cliente = new Cliente(idCliente, nombre, apellido, membresia);
                var modificado = clienteDAO.modificarCliente(cliente);
                if (modificado) {
                    System.out.println("Cliente modificado: " + cliente);
                } else {
                    System.out.println("Cliente NO modificado: " + cliente);
                }
            }
            case 5 -> {
                System.out.println("--- Eliminar Cliente ---");
                System.out.print("Id Cliente: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                var cliente = new Cliente(idCliente);
                var eliminado = clienteDAO.eliminarCliente(cliente);
                if (eliminado) {
                    System.out.println("Cliente eliminado: " + cliente);
                } else {
                    System.out.println("Cliente NO eliminado: " + cliente);
                }
            }
            case 6 -> {
                System.out.println("Hasta pronto!!!");
                salir = true;
            }
            default -> {
                System.out.println("Opción no encontrada: " + opcion);
            }
        }
        return salir;
    }
}

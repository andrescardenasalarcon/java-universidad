package com.zona_fit;

import com.zona_fit.models.Cliente;
import com.zona_fit.service.IClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

//@SpringBootApplication  --> desactivamos esta clase para darle main al ZonaFitSwing
@Service
public class ZonaFitApplication implements CommandLineRunner {

    @Autowired
    private IClienteServicio clienteServicio;

    //Logger --> para enviar la inf a consola como si fuera un sout
    private static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class);

    String newLine = System.lineSeparator();

    public static void main(String[] args) {
        logger.info("Iniciando la aplicación");
        //Levanta la fabica de spring
        SpringApplication.run(ZonaFitApplication.class, args);
        logger.info("Aplicación Finalizada!!!");
    }

    @Override
    public void run(String... args) throws Exception {
        zonaFitApp();
    }

    private void zonaFitApp() {
        var salir = false;
        var consola = new Scanner(System.in);
        while (!salir) {
            try {
                var opcion = mostrarMenu(consola);
                salir = ejcutarOpciones(consola, opcion);
            } catch (Exception e) {
                logger.error("Error al ejecutar opciones: " + e.getMessage());
            }
            logger.info(newLine);
        }
    }

    private int mostrarMenu(Scanner consola) {
        logger.info("""
                \n*** Aplicación Zona Fit (GYM) ***
                1. Listar Clientes
                2. Buscar Cliente
                3. Agregar Cliente
                4. Modificar Cliente
                5. Eliminar Cliente
                6. Salir
                Elige una opcion:\s""");
        return Integer.parseInt(consola.nextLine());
    }

    private boolean ejcutarOpciones(Scanner consola, int opcion) {
        var salir = false;
        switch (opcion) {
            case 1 -> {
                logger.info(newLine + "--- Listado de clientes ---" + newLine);
                List<Cliente> clientes = clienteServicio.listarClientes();
                clientes.forEach(cliente -> logger.info(cliente.toString() + newLine));
            }
            case 2 -> {
                logger.info(newLine + "--- Buscar Cliente ---" + newLine);
                logger.info("Id Cliente a buscar: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
                if (cliente != null) {
                    logger.info("Cliente encontrado: " + cliente + newLine);
                } else {
                    logger.info("Cliente NO encontrado: " + cliente + newLine);
                }
            }
            case 3 -> {
                logger.info(newLine + "--- Agregar Cliente ---" + newLine);
                logger.info("Nombre: ");
                var nombre = consola.nextLine();
                logger.info("Apellido: ");
                var apellido = consola.nextLine();
                logger.info("Membresia: ");
                var membresia = Integer.parseInt(consola.nextLine());
                var cliente = new Cliente();
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setMembresia(membresia);
                clienteServicio.guardarCliente(cliente);
                logger.info("Cliente agregado: " + cliente + newLine);
            }
            case 4 -> {
                logger.info(newLine + "--- Modificar Cliente ---" + newLine);
                logger.info("Id Cliente a Modificar: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
                if (cliente != null) {
                    logger.info("Nombre: ");
                    var nombre = consola.nextLine();
                    logger.info("Apellido: ");
                    var apellido = consola.nextLine();
                    logger.info("Membresia: ");
                    var membresia = Integer.parseInt(consola.nextLine());
                    cliente.setNombre(nombre);
                    cliente.setApellido(apellido);
                    cliente.setMembresia(membresia);
                    clienteServicio.guardarCliente(cliente);
                    logger.info("Cliente modificado: " + cliente + newLine);
                } else {
                    logger.info("Cliente NO encontrado: " + idCliente + newLine);
                }
            }
            case 5 -> {
                logger.info(newLine + "--- Eliminar Cliente ---" + newLine);
                logger.info("Id Cliente a Eliminar: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
                if (cliente != null) {
                    clienteServicio.eliminarCliente(cliente);
                    logger.info("Cliente eliminado: " + cliente + newLine);
                } else {
                    logger.info("Cliente NO encontrado: " + idCliente + newLine);
                }
            }
            case 6 -> {
                logger.info(newLine + "--- Vuelva Pronto!!! ---" + newLine);
                salir = true;
            }
            default -> logger.info("Opción no reconocida" + opcion + newLine);
        }
        return salir;
    }
}

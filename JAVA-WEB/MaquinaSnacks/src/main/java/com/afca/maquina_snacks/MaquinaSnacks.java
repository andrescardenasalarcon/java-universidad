package com.afca.maquina_snacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {
    public static void main(String[] args) {
        maquinaSnacks();
    }

    public static void maquinaSnacks() {
        var salir = false;
        var consola = new Scanner(System.in);
        //Creamos la lista de productos de tipo snack
        List<Snack> produtos = new ArrayList<Snack>();
        System.out.println("*** Maquina de Snacks ***");
        Snacks.mostrarSnacks(); //Mostrar inventario de snacks disponibles
        while (!salir) {
            try {
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(opcion, consola, produtos);
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }

    private static int mostrarMenu(Scanner consola) {
        System.out.print("""
                Menu:
                1. Comprar snack
                2. Mostrar ticket
                3. Agregar Nuevo Snack
                4. Salir
                Elige una opcion:\s""");
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Snack> produtos) {
        var salir = false;
        switch (opcion) {
            case 1 -> comprarSnack(consola, produtos);
            case 2 -> mostrarTicket(produtos);
            case 3 -> agregarSnack(consola);
            case 4 -> {
                System.out.println("Regresa pronto!");
                salir = true;
            }
            default -> System.out.println("Opcion invalida: " + opcion);
        }
        return salir;
    }

    private static void comprarSnack(Scanner consola, List<Snack> produtos) {
        System.out.print("¿Que snack quieres comprar (id)? ");
        var idSnack = Integer.parseInt(consola.nextLine());
        //Validar que el snack exista en la lista de snacks
        var snackEncontrado = false;
        for (var snack : Snacks.getSnacks()) {
            if (idSnack == snack.getIdSnack()) {
                //Agregamos el snack a la lista de productos
                produtos.add(snack);
                System.out.println("Ok, Snack agregado: " + snack);
                snackEncontrado = true;
                break;
            }
        }
        if (!snackEncontrado) {
            System.out.println("Id de snack no encontrado: " + idSnack);
        }
    }

    private static void mostrarTicket(List<Snack> produtos) {
        String ticket = "*** Ticket de Venta ***";
        var total = 0.0;
        for (var producto : produtos) {
            ticket += "\n\t- " + producto.getSnackName() + " - $" + producto.getPrice();
            total += producto.getPrice();
        }
        ticket += "\n\tTotal -> $" + total;
        System.out.println(ticket);

    }

    private static void agregarSnack(Scanner consola) {
        System.out.print("Nombre del sanck: ");
        var nombre = consola.nextLine();
        System.out.print("Precio del snack: ");
        var precio = Double.parseDouble(consola.nextLine());
        Snacks.agregarSnack(new Snack(nombre, precio));
        System.out.print("Tu snack se ha agregado correctamente");
        Snacks.mostrarSnacks();
    }
}

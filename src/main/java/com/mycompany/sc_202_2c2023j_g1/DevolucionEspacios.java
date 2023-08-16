package com.mycompany.sc_202_2c2023j_g1;



import java.util.Scanner;

public class DevolucionEspacios {
    public static void main(String[] args) {
        // Crear un arreglo de objetos de tipo Barbero
        Barbero[] barberos = {
            new Barbero("Juan", 12),
            new Barbero("Pedro", 13),
            new Barbero("Luis", 14),
            new Barbero("Carlos", 12),
            new Barbero("Miguel", 13)
        };
        
        // Solicitar los datos al cliente
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        
        System.out.print("Ingrese el nombre del barbero: ");
        String nombreBarbero = scanner.nextLine();
        
        System.out.print("Ingrese el día de la reservación: ");
        String diaReservacion = scanner.nextLine();
        
        // Buscar la reservación del cliente
        boolean reservacionEncontrada = false;
        
        for (Barbero barbero : barberos) {
            if (barbero.eliminarReservacion(nombreCliente, nombreBarbero, diaReservacion)) {
                reservacionEncontrada = true;
                break;
            }
        }
        
        if (reservacionEncontrada) {
            System.out.println("La reservación del cliente " + nombreCliente + " ha sido eliminada exitosamente.");
        } else {
            System.out.println("No se encontró ninguna reservación para el cliente " + nombreCliente + " con el barbero " + nombreBarbero + " en el día " + diaReservacion);
        }
    }
}
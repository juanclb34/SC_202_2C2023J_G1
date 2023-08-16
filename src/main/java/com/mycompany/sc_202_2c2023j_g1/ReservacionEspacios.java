package com.mycompany.sc_202_2c2023j_g1;
import java.util.Scanner;

public class ReservacionEspacios {
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
        
        System.out.print("Ingrese el teléfono del cliente: ");
        String telefonoCliente = scanner.nextLine();
        
        System.out.print("Ingrese el día de la reservación: ");
        String diaReservacion = scanner.nextLine();
        
        System.out.print("Ingrese el rango de horas (inicio-fin): ");
        String rangoHoras = scanner.nextLine();
        
        // Buscar un barbero disponible para la reservación
        Barbero barberoDisponible = buscarBarberoDisponible(barberos, diaReservacion, rangoHoras);
        
        if (barberoDisponible != null) {
            // Calcular el precio de la reservación
            double precioHora = calcularPrecioHora(diaReservacion);
            double total = calcularTotal(precioHora, rangoHoras);
            
            // Aplicar el IVA
            double totalConIVA = aplicarIVA(total);
            
            // Mostrar los detalles de la reservación al cliente
            System.out.println("Reservación exitosa para el cliente " + nombreCliente);
            System.out.println("Teléfono: " + telefonoCliente);
            System.out.println("Día de la reservación: " + diaReservacion);
            System.out.println("Rango de horas: " + rangoHoras);
            System.out.println("Barbero asignado: " + barberoDisponible.getNombre());
            System.out.println("Precio por hora: " + precioHora + " colones");
            System.out.println("Total a pagar (con IVA): " + totalConIVA + " colones");
        } else {
            System.out.println("No hay barberos disponibles para la reservación en el día y rango de horas especificados.");
        }
    }
    
    public static Barbero buscarBarberoDisponible(Barbero[] barberos, String diaReservacion, String rangoHoras) {
        // Recorrer los barberos y verificar si tienen el espacio disponible en el día y rango de horas especificados
        for (Barbero barbero : barberos) {
            if (barbero.tieneEspacioDisponible(diaReservacion, rangoHoras)) {
                return barbero;
            }
        }
        
        return null;
    }
    
    public static double calcularPrecioHora(String diaReservacion) {
        // Verificar si el día de la reservación es entre semana o fin de semana y asignar el precio correspondiente
        if (diaReservacion.equalsIgnoreCase("sábado") || diaReservacion.equalsIgnoreCase("domingo")) {
            return 3000;
        } else {
            return 2500;
        }
    }
    
    public static double calcularTotal(double precioHora, String rangoHoras) {
        // Calcular la cantidad de horas y multiplicar por el precio por hora
        String[] horas = rangoHoras.split("-");
        int inicio = Integer.parseInt(horas[0]);
        int fin = Integer.parseInt(horas[1]);
        int cantidadHoras = fin - inicio + 1;
        
        return precioHora * cantidadHoras;
    }
    
    public static double aplicarIVA(double total) {
        // Calcular el IVA (13%) y sumarlo al total
        double iva = total * 0.13;
        return total + iva;
    }
}
package com.mycompany.sc_202_2c2023j_g1;

import java.util.Scanner;

/**
 *
 * @author Juan Carlos
 */
public class SC_202_2C2023J_G1 {

    public static void main(String[] args) {
        // Crear un arreglo para almacenar las citas de los barberos
        String[][] citas = new String[5][10]; // 5 barberos y 10 horas disponibles
        
        // Configurar la hora de almuerzo (12 pm) para cada barbero
        for (int i = 0; i < 5; i++) {
            citas[i][4] = "Almuerzo";
        }
        
        // Mostrar el menú de opciones al usuario
        int opcion;
        do {
            System.out.println("----- Barbería -----");
            System.out.println("1. Ver citas");
            System.out.println("2. Agendar cita");
            System.out.println("3. Eliminar cita");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            
            Scanner scanner = new Scanner(System.in);
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    verCitas(citas);
                    break;
                case 2:
                    agendarCita(citas);
                    break;
                case 3:
                    eliminarCita(citas);
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
            
            System.out.println();
        } while (opcion != 4);
    }
    
    public static void verCitas(String[][] citas) {
        System.out.println("----- Citas -----");
        for (int i = 0; i < 5; i++) {
            System.out.println("Barbero " + (i + 1) + ":");
            for (int j = 0; j < 10; j++) {
                if (citas[i][j] != null) {
                    System.out.println("Hora " + (j + 8) + ": " + citas[i][j]);
                }
            }
            System.out.println();
        }
    }
    
    public static void agendarCita(String[][] citas) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el número del barbero (1-5): ");
        int barbero = scanner.nextInt() - 1;
        
        System.out.print("Ingrese la hora de la cita (8-17): ");
        int hora = scanner.nextInt() - 8;
        
        System.out.print("Ingrese el nombre del cliente: ");
        String cliente = scanner.next();
        
        if (citas[barbero][hora] == null) {
            citas[barbero][hora] = cliente;
            System.out.println("Cita agendada exitosamente.");
        } else {
            System.out.println("La hora seleccionada ya está ocupada. Intente nuevamente.");
        }
    }
    
    public static void eliminarCita(String[][] citas) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el número del barbero (1-5): ");
        int barbero = scanner.nextInt() - 1;
        
        System.out.print("Ingrese la hora de la cita (8-17): ");
        int hora = scanner.nextInt() - 8;
        
        if (citas[barbero][hora] != null) {
            citas[barbero][hora] = null;
            System.out.println("Cita eliminada exitosamente.");
        } else {
            System.out.println("No hay una cita agendada en la hora seleccionada. Intente nuevamente.");
        }
    }
}

package com.mycompany.sc_202_2c2023j_g1;

/**
 *
 * @author Juan Carlos
 */

import java.util.Scanner;

public class SC_202_2C2023J_G1{
  
    private static final int NUM_HORAS = 10; // 10 horas laborales (8:00 - 17:30)
    private static final int NUM_BARBEROS = 5; // 5 barberos
    private static final String[] nombresBarberos = new String[NUM_BARBEROS];
    private static final int[] horasAlmuerzo = new int[NUM_BARBEROS];

public static void main(String[] args) {
        // Inicializar la matriz de calendario
        boolean[][][] calendario = new boolean[NUM_BARBEROS][NUM_HORAS][2]; // 2 espacios por hora (30 minutos cada uno)

        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Sistema de Gestión de Barbería");
            System.out.println("1. Programar Cita");
            System.out.println("2. Cancelar Cita");
            System.out.println("3. Ver Calendario");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    programarCita(calendario);
                    break;
                case 2:
                    cancelarCita(calendario);
                    break;
                case 3:
                    verCalendario(calendario);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor ingrese una opción válida.");
                    break;
            }
        } while (opcion != 4);

        scanner.close();
    }
    
    // Nueva función para administrar el personal
    private static void administrarPersonal() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Administración del Personal");
        System.out.println("1. Registrar Horario de Almuerzo");
        // Aquí podrían agregarse más opciones para administrar el personal
        System.out.println("2. Volver al Menú Principal");
        System.out.print("Ingrese su opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                registrarHorarioAlmuerzo();
                break;
            case 2:
                System.out.println("Volviendo al Menú Principal.");
                break;
            default:
                System.out.println("Opción inválida. Volviendo al Menú Principal.");
                break;
        }
    }

    // Nueva función para registrar el horario de almuerzo de un barbero
    private static void registrarHorarioAlmuerzo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Registrar Horario de Almuerzo");
        System.out.print("Ingrese el número del barbero (1-" + NUM_BARBEROS + "): ");
        int barbero = scanner.nextInt() - 1;

        if (barbero >= 0 && barbero < NUM_BARBEROS) {
            System.out.print("Ingrese la hora de almuerzo (8-16): ");
            int horaAlmuerzo = scanner.nextInt();

            if (horaAlmuerzo >= 8 && horaAlmuerzo <= 16) {
                nombresBarberos[barbero] = "Barbero " + (barbero + 1);
                horasAlmuerzo[barbero] = horaAlmuerzo;
                System.out.println("Horario de almuerzo registrado correctamente.");
            } else {
                System.out.println("Hora de almuerzo inválida.");
            }
        } else {
            System.out.println("Número de barbero inválido.");
        }
    }

    private static void programarCita(boolean[][][] calendario) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número del barbero (1-" + NUM_BARBEROS + "): ");
        int barbero = scanner.nextInt() - 1;

        System.out.print("Ingrese la hora (8-17): ");
        int hora = scanner.nextInt() - 8;

        System.out.println("Seleccione espacio: 1. 8:00-8:30 | 2. 8:30-9:00 |  ... | 19. 17:30-18:00");
        int espacio = scanner.nextInt() - 1;

        if (hora >= 0 && hora < NUM_HORAS && espacio >= 0 && espacio < 20) {
            if (!calendario[barbero][hora][espacio]) {
                calendario[barbero][hora][espacio] = true;
                System.out.println("Cita programada exitosamente.");
            } else {
                System.out.println("El espacio ya está reservado. Por favor elija otro espacio.");
            }
        } else {
            System.out.println("Hora o espacio inválido.");
        }
    }

    private static void cancelarCita(boolean[][][] calendario) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número del barbero (1-" + NUM_BARBEROS + "): ");
        int barbero = scanner.nextInt() - 1;

        System.out.print("Ingrese la hora (8-17): ");
        int hora = scanner.nextInt() - 8;

        System.out.println("Seleccione espacio a cancelar: 1. 8:00-8:30 | 2. 8:30-9:00 | ... | 19. 17:30-18:00");
        int espacio = scanner.nextInt() - 1;

        if (hora >= 0 && hora < NUM_HORAS && espacio >= 0 && espacio < 20) {
            if (calendario[barbero][hora][espacio]) {
                calendario[barbero][hora][espacio] = false;
                System.out.println("Cita cancelada exitosamente.");
            } else {
                System.out.println("No se encontró ninguna cita en este espacio.");
            }
        } else {
            System.out.println("Hora o espacio inválido.");
        }
    }

    private static void verCalendario(boolean[][][] calendario) {
        System.out.println("Calendario de la Barbería:");
        for (int barbero = 0; barbero < NUM_BARBEROS; barbero++) {
            System.out.println("Horario del Barbero " + (barbero + 1) + ":");
            for (int hora = 0; hora < NUM_HORAS; hora++) {
                System.out.print((hora + 8) + ":00 - " + (hora + 8) + ":30 | ");
                for (int espacio = 0; espacio < 2; espacio++) {
                    System.out.print(calendario[barbero][hora][espacio] ? "X" : "_");
                    if (espacio == 0) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}

    
  
      
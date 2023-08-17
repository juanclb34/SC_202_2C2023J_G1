package com.mycompany.sc_202_2c2023j_g1;


/**
 *
 * @author Juan Carlos
 */

import java.util.Scanner;

public class SistemaGestionBarberia {
    
    private static final int NUM_BARBEROS = 5;
    private static final int NUM_HORAS = 10; // De 8 am a 6 pm, excluyendo la hora del almuerzo
    private static final double PRECIO_HORA_SEMANA = 2500;
    private static final double PRECIO_HORA_FIN_DE_SEMANA = 3000;
    
    private static final String[] nombresBarberos = new String[NUM_BARBEROS];
    private static final int[] horasAlmuerzo = new int[NUM_BARBEROS];
    private static final String[][] nombresClientes = new String[NUM_BARBEROS][NUM_HORAS];
    private static final String[][] telefonosClientes = new String[NUM_BARBEROS][NUM_HORAS];
    
    // Nueva función para realizar la reservación de espacios
    private static void reservarEspacio(boolean[][][] calendario) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Reservación de Espacios");
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();

        System.out.print("Ingrese el teléfono del cliente: ");
        String telefonoCliente = scanner.nextLine();

        System.out.print("Ingrese el día en que será atendido (1-31): ");
        int dia = scanner.nextInt();

        System.out.println("Seleccione el rango de horas:");
        System.out.println("1. 8:00-10:00");
        System.out.println("2. 10:00-12:00");
        System.out.println("3. 12:00-14:00");
        System.out.println("4. 14:00-16:00");
        System.out.println("5. 16:00-18:00");
        System.out.print("Ingrese su opción: ");
        int opcionHora = scanner.nextInt();

        if (opcionHora >= 1 && opcionHora <= 5) {
            int horaInicio = (opcionHora - 1) * 2; // Convertir la opción a un rango de horas
            int horaFin = horaInicio + 2;

            System.out.print("¿Es fin de semana? (Sí: 1, No: 0): ");
            int esFinDeSemana = scanner.nextInt();

            double precioHora = esFinDeSemana == 1 ? 3000 : 2500;
            double precioTotal = (precioHora * 2) * 1.13; // 2 horas * precio con IVA

            int barberoDisponible = encontrarBarberoDisponible(calendario, dia, horaInicio, horaFin);

            if (barberoDisponible != -1) {
                calendario[barberoDisponible][horaInicio][0] = true;
                calendario[barberoDisponible][horaInicio][1] = true;
                System.out.println("Cita reservada con éxito para el cliente " + nombreCliente);
                System.out.println("Barbero asignado: Barbero " + (barberoDisponible + 1));
                System.out.println("Horario: " + (horaInicio + 8) + ":00 - " + (horaFin + 8) + ":00");
                System.out.println("Precio Total: " + precioTotal + " colones");
            } else {
                System.out.println("Lo sentimos, no hay barberos disponibles en ese horario.");
            }
        } else {
            System.out.println("Opción de rango de horas inválida.");
        }
    }

    // Nueva función para encontrar un barbero disponible en el día y rango de horas especificado
    private static int encontrarBarberoDisponible(boolean[][][] calendario, int dia, int horaInicio, int horaFin) {
        for (int barbero = 0; barbero < NUM_BARBEROS; barbero++) {
            boolean disponible = true;
            for (int hora = horaInicio; hora < horaFin; hora++) {
                if (calendario[barbero][hora][0] || calendario[barbero][hora][1]) {
                    disponible = false;
                    break;
                }
            }
            if (disponible) {
                return barbero;
            }
        }
        return -1; // No se encontró ningún barbero disponible
    }
    
    
    
     // Nueva función para realizar la devolución de espacios
    private static void devolverEspacio(boolean[][][] calendario) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Devolución de Espacios");
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();

        System.out.print("Ingrese el número del barbero (1-" + NUM_BARBEROS + "): ");
        int barbero = scanner.nextInt() - 1;

        System.out.print("Ingrese el día en que iba a ser atendido (1-31): ");
        int dia = scanner.nextInt();

        boolean encontrada = false;

        for (int hora = 0; hora < NUM_HORAS; hora++) {
            if (calendario[barbero][hora][0] && calendario[barbero][hora][1]) {
                calendario[barbero][hora][0] = false;
                calendario[barbero][hora][1] = false;
                encontrada = true;
                break;
            }
        }

        if (encontrada) {
            System.out.println("Reservación eliminada con éxito para el cliente " + nombreCliente);
            System.out.println("Espacio disponible nuevamente para ser utilizado.");
        } else {
            System.out.println("No se encontró una reservación para el cliente " + nombreCliente +
                               " en el día y barbero especificados.");
        }
    }
    
    
    // Nueva función para revisar la agenda de un barbero
    private static void revisarAgenda(boolean[][][] calendario) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Revisión de Agendas");
        System.out.print("Ingrese el número del barbero (1-" + NUM_BARBEROS + "): ");
        int barbero = scanner.nextInt() - 1;

        System.out.print("Ingrese el día de la reservación (1-31): ");
        int dia = scanner.nextInt();

        System.out.println("Agenda del Barbero " + (barbero + 1) + " para el día " + dia + ":");

        double totalRecaudado = 0;

        for (int hora = 0; hora < NUM_HORAS; hora++) {
            System.out.print((hora + 8) + ":00 - " + (hora + 8) + ":30 | ");

            if (hora == horasAlmuerzo[barbero]) {
                System.out.println("HORA DE ALMUERZO");
            } else {
                if (calendario[barbero][hora][0] && calendario[barbero][hora][1]) {
                    String nombreCliente = nombresClientes[barbero][hora];
                    String telefonoCliente = telefonosClientes[barbero][hora];
                    double precioHora = esFinDeSemana(dia) ? PRECIO_HORA_FIN_DE_SEMANA : PRECIO_HORA_SEMANA;
                    double precioTotal = precioHora * 2;
                    totalRecaudado += precioTotal;

                    System.out.println(nombreCliente + " - " + telefonoCliente + " | Precio: " + precioTotal + " colones");
                } else if (calendario[barbero][hora][0] || calendario[barbero][hora][1]) {
                    System.out.println("—VACIO—");
                } else {
                    System.out.println();
                }
            }
        }

        System.out.println("Monto total a recaudar ese día: " + totalRecaudado + " colones");
    }

    // Función auxiliar para verificar si un día es fin de semana
    private static boolean esFinDeSemana(int dia) {
        // Supongamos que los días 6 (sábado) y 7 (domingo) son fines de semana
        return dia == 6 || dia == 7;
    }
    
}














    


   
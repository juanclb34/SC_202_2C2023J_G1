package com.mycompany.sc_202_2c2023j_g1;


import java.util.Scanner;

public class RevisionAgendas {
    public static void main(String[] args) {
        // Crear un arreglo de objetos de tipo Barbero
        Barbero[] barberos = {
            new Barbero("Juan", 12),
            new Barbero("Pedro", 13),
            new Barbero("Luis", 14),
            new Barbero("Carlos", 12),
            new Barbero("Miguel", 13)
        };

        // Solicitar los datos al usuario
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del barbero: ");
        String nombreBarbero = scanner.nextLine();

        System.out.print("Ingrese el día de la reservación: ");
        String diaReservacion = scanner.nextLine();

        // Buscar el barbero en el arreglo
        Barbero barberoSeleccionado = null;

        for (Barbero barbero : barberos) {
            if (barbero.getNombre().equalsIgnoreCase(nombreBarbero)) {
                barberoSeleccionado = barbero;
                break;
            }
        }

        if (barberoSeleccionado != null) {
            // Mostrar la agenda del barbero para el día seleccionado
            System.out.println("Agenda del barbero " + barberoSeleccionado.getNombre() + " para el día " + diaReservacion + ":");

            for (int i = 8; i <= 17; i++) {
                String hora = i + ":00";
                String cliente = barberoSeleccionado.getClienteEnHora(diaReservacion, hora);

                if (cliente != null) {
                    System.out.println(hora + " - Cliente: " + cliente + " - Teléfono: " + barberoSeleccionado.getTelefonoCliente(diaReservacion, hora));
                } else {
                    if (i == barberoSeleccionado.getHoraAlmuerzo()) {
                        System.out.println(hora + " - HORA DE ALMUERZO");
                    } else {
                        System.out.println(hora + " - VACIO");
                    }
                }
            }

            // Calcular el monto de dinero a recaudar ese día
            double precioHora = calcularPrecioHora(diaReservacion);
            double montoRecaudar = calcularMontoRecaudar(barberoSeleccionado, diaReservacion, precioHora);

            System.out.println("Monto a recaudar para el día " + diaReservacion + ": " + montoRecaudar + " colones");
        } else {
            System.out.println("No se encontró el barbero especificado.");
        }
    }

    public static double calcularPrecioHora(String diaReservacion) {
        // Verificar si el día de la reservación es entre semana o fin de semana y asignar el precio correspondiente
        if (diaReservacion.equalsIgnoreCase("sábado") || diaReservacion.equalsIgnoreCase("domingo")) {
            return 3000;
        } else {
            return 2500;
        }
    }

    public static double calcularMontoRecaudar(Barbero barbero, String diaReservacion, double precioHora) {
        double montoRecaudar = 0;

        for (int i = 8; i <= 17; i++) {
            String hora = i + ":00";
            String cliente = barbero.getClienteEnHora(diaReservacion, hora);

            if (cliente != null) {
                montoRecaudar += precioHora;
            }
        }

        return montoRecaudar;
    }
}
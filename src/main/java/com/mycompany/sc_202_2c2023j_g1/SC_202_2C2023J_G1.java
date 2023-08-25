package com.mycompany.sc_202_2c2023j_g1;

/**
 *
 * @author Juan Carlos
 */

import javax.swing.JOptionPane;

    public class SC_202_2C2023J_G1 {
       
    private static final int NUMERO_BARBEROS = 5;
    private static final int HORARIO_INICIO = 8;
    private static final int HORARIO_FIN = 18;
    private static final int HORA_ALMUERZO = 12;
    private static final double PRECIO_HORA_SEMANA = 2500;
    private static final double PRECIO_HORA_FINDE = 3000;
    private static final double IVA = 0.13;

    private static final String[][] calendario = new String[NUMERO_BARBEROS][HORARIO_FIN - HORARIO_INICIO];
    private static final String[] nombresBarberos = new String[NUMERO_BARBEROS];
    private static final int[] horasAlmuerzo = new int[NUMERO_BARBEROS];

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            int opcion = mostrarMenu();

            switch (opcion) {
                case 1:
                    registrarBarbero();
                    break;
                case 2:
                    reservarCita();
                    break;
                case 3:
                    mostrarCalendario();
                    break;
                case 4:
                    eliminarHoraAlmuerzo();
                    break;
                case 5:
                    devolverEspacio();
                    break;
                case 6:
                    revisarAgenda();
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, intenta de nuevo.");
                    break;
            }
        }
    }

    private static int mostrarMenu() {
        String menu = "**********Bienvenidos a Barbería Corrales********** \n\n";
        menu += "1. Registrar barbero\n";
        menu += "2. Reservar cita\n";
        menu += "3. Mostrar calendario\n";
        menu += "4. Eliminar hora de almuerzo\n";
        menu += "5. Devolver espacio\n";
        menu += "6. Revisar agenda\n";
        menu += "7. Salir\n\n";
        menu += "Ingresa el número de la opción deseada:";
        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }

    private static void registrarBarbero() {
        int barbero = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el número de barbero (1-5):"));
        String nombre = JOptionPane.showInputDialog("Ingresa el nombre del barbero:");
        int horaAlmuerzo = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la hora de almuerzo del barbero (8-18):"));

        if (horaAlmuerzo < HORARIO_INICIO || horaAlmuerzo >= HORARIO_FIN) {
            JOptionPane.showMessageDialog(null, "Hora de almuerzo inválida. Debe estar entre las 8am y las 6pm.");
            return;
        }

        nombresBarberos[barbero - 1] = nombre;
        horasAlmuerzo[barbero - 1] = horaAlmuerzo;

        JOptionPane.showMessageDialog(null, "Barbero registrado exitosamente.");
    }

    private static void reservarCita() {
        String nombreCliente = JOptionPane.showInputDialog("Ingresa el nombre del cliente:");
        String telefonoCliente = JOptionPane.showInputDialog("Ingresa el teléfono del cliente:");
        int dia = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el día de la cita (1-31):"));
        int horaInicio = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la hora de inicio de la cita (8-17):"));
        int duracion = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la duración de la cita en horas:"));

        if (horaInicio < HORARIO_INICIO || horaInicio >= HORARIO_FIN) {
            JOptionPane.showMessageDialog(null, "Hora de inicio inválida. Debe estar entre las 8am y las 6pm.");
            return;
        }

        if (duracion < 1 || duracion > (HORARIO_FIN - HORARIO_INICIO)) {
            JOptionPane.showMessageDialog(null, "Duración inválida. Debe ser mínimo 1 hora y máximo " + (HORARIO_FIN - HORARIO_INICIO) + " horas.");
            return;
        }

        int barberoDisponible = encontrarBarberoDisponible(dia, horaInicio, duracion);

        if (barberoDisponible == -1) {
            JOptionPane.showMessageDialog(null, "No hay barberos disponibles para la cita solicitada.");
            return;
        }

        double precioHora = obtenerPrecioHora(dia);
        double subtotal = precioHora * duracion;
        double total = subtotal + (subtotal * IVA);

        calendario[barberoDisponible][horaInicio - HORARIO_INICIO] = nombreCliente;

        JOptionPane.showMessageDialog(null, "Cita reservada exitosamente.\n\n"
                + "Cliente: " + nombreCliente + "\n"
                + "Teléfono: " + telefonoCliente + "\n"
                + "Barbero: " + nombresBarberos[barberoDisponible] + "\n"
                + "Fecha: " + dia + "\n"
                + "Hora de inicio: " + horaInicio + ":00\n"
                + "Duración: " + duracion + " hora(s)\n"
                + "Precio por hora: " + precioHora + " colones\n"
                + "Subtotal: " + subtotal + " colones\n"
                + "Total (con IVA): " + total + " colones");
    }

    private static int encontrarBarberoDisponible(int dia, int horaInicio, int duracion) {
        int horaFin = horaInicio + duracion;

        for (int barbero = 0; barbero < NUMERO_BARBEROS; barbero++) {
            boolean disponible = true;

            for (int hora = horaInicio; hora < horaFin; hora++) {
                if (hora == horasAlmuerzo[barbero] || calendario[barbero][hora - HORARIO_INICIO] != null) {
                    disponible = false;
                    break;
                }
            }

            if (disponible) {
                return barbero;
            }
        }

        return -1;
    }

    private static double obtenerPrecioHora(int dia) {
        if (esFinDeSemana(dia)) {
            return PRECIO_HORA_FINDE;
        } else {
            return PRECIO_HORA_SEMANA;
        }
    }

    private static boolean esFinDeSemana(int dia) {
        // Suponemos que el día 1 corresponde al lunes
        int diaSemana = (dia + 5) % 7;

        return diaSemana == 5 || diaSemana == 6;
    }

    private static void mostrarCalendario() {
        String calendarioStr = "CALENDARIO DE CITAS\n\n";

        for (int i = 0; i < NUMERO_BARBEROS; i++) {
            calendarioStr += "Barbero " + (i + 1) + ": " + nombresBarberos[i] + "\n";

            for (int j = 0; j < HORARIO_FIN - HORARIO_INICIO; j++) {
                if (j == horasAlmuerzo[i] - HORARIO_INICIO) {
                    calendarioStr += "   [ALMUERZO]\n";
                }

                calendarioStr += "   " + (j + HORARIO_INICIO) + ":00 - ";

                if (calendario[i][j] != null) {
                    calendarioStr += calendario[i][j];
                } else {
                    calendarioStr += "[Disponible]";
                }

                calendarioStr += "\n";
            }

            calendarioStr += "\n";
        }

        JOptionPane.showMessageDialog(null, calendarioStr);
    }

    private static void eliminarHoraAlmuerzo() {
        int barbero = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el número de barbero (1-5):"));

        if (horasAlmuerzo[barbero - 1] == 0) {
            JOptionPane.showMessageDialog(null, "El barbero no tiene una hora de almuerzo registrada.");
            return;
        }

        horasAlmuerzo[barbero - 1] = 0;

        JOptionPane.showMessageDialog(null, "Hora de almuerzo eliminada correctamente.");
    }

    private static void devolverEspacio() {
        String nombreCliente = JOptionPane.showInputDialog("Ingresa el nombre del cliente:");
        int barbero = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el número de barbero (1-5):"));
        int dia = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el día de la cita (1-31):"));

        boolean encontrado = false;

        for (int i = 0; i < HORARIO_FIN - HORARIO_INICIO; i++) {
            if (calendario[barbero - 1][i] != null && calendario[barbero - 1][i].equals(nombreCliente)) {
                calendario[barbero - 1][i] = null;
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            JOptionPane.showMessageDialog(null, "La reservación ha sido eliminada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna reservación para el cliente especificado.");
        }
    }

    private static void revisarAgenda() {
        int barbero = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el número de barbero (1-5):"));
        int dia = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el día a revisar (1-31):"));

        String agenda = "AGENDA DEL BARBERO " + nombresBarberos[barbero - 1] + " - DÍA " + dia + "\n\n";

        for (int hora = HORARIO_INICIO; hora < HORARIO_FIN; hora++) {
            if (hora == horasAlmuerzo[barbero - 1]) {
                agenda += "   [HORA DE ALMUERZO]\n";
            }

            agenda += "   " + hora + ":00 - ";

            if (calendario[barbero - 1][hora - HORARIO_INICIO] != null) {
                agenda += "Cliente: " + calendario[barbero - 1][hora - HORARIO_INICIO];
            } else {
                agenda += "---VACIO---";
            }

            agenda += "\n";
        }

        double montoRecaudado = calcularMontoRecaudado(barbero - 1, dia);

        agenda += "\nMonto recaudado: " + montoRecaudado + " colones";

        JOptionPane.showMessageDialog(null, agenda);
    }

    private static double calcularMontoRecaudado(int barbero, int dia) {
        double montoRecaudado = 0;

        for (int hora = HORARIO_INICIO; hora < HORARIO_FIN; hora++) {
            if (calendario[barbero][hora - HORARIO_INICIO] != null) {
                double precioHora = obtenerPrecioHora(dia);
                montoRecaudado += precioHora;
            }
        }

        return montoRecaudado;
    }
}
       




    






























  
      
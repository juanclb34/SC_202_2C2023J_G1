/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sc_202_2c2023j_g1;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author Mercedes León
 */
public class CitasManager {
    private Map<Barbero, Map<String, Cliente>> agenda;

    public CitasManager() {
        agenda = new HashMap<>();
    }

    // Método para reservar una cita
    public void reservarCita(Cliente cliente, Barbero barbero) {
        Map<String, Cliente> citasBarbero = agenda.getOrDefault(barbero, new HashMap<>());
        String fechaCitaStr = fechaToString(cliente.getFechaCita());
        citasBarbero.put(fechaCitaStr, cliente);
        agenda.put(barbero, citasBarbero);
    }

    // Método para devolución de espacios
    public void mostrarAgendaDelBarbero(Barbero barbero, String fecha) {
        System.out.println("Agenda del barbero " + barbero.getNombre() + " para el día " + fecha + ":");

        Map<String, Cliente> citasBarbero = agenda.getOrDefault(barbero, new HashMap<>());

        // Horario de trabajo del barbero
        int horaInicio = 8;
        int horaFin = 18;

        for (int hora = horaInicio; hora < horaFin; hora++) {
            String horaStr = String.format("%02d:00", hora);

            if (horaStr.equals(barbero.getHoraAlmuerzo())) {
                System.out.println(horaStr + " - HORA DE ALMUERZO");
            } else {
                String fechaHoraStr = fecha + " " + horaStr;
                Cliente clienteEnHora = citasBarbero.getOrDefault(fechaHoraStr, null);

                if (clienteEnHora != null) {
                    System.out.println(horaStr + " - " + clienteEnHora.getNombre() + " (" + clienteEnHora.getTelefono() + ")");
                } else {
                    System.out.println(horaStr + " - ---VACIO---");
                }
            }
        }

        // Calcular el monto total a recaudar ese día
        double montoTotal = 0;
        boolean esFinDeSemana = isFinDeSemana(fecha);

        for (Cliente cliente : citasBarbero.values()) {
            montoTotal += Servicios.calcularCostoServicio(cliente.getDuracionHoras(), esFinDeSemana);
        }

        System.out.println("Monto total a recaudar ese día: " + montoTotal + " colones");
    }

    private String fechaToString(Calendar fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return sdf.format(fecha.getTime());
    }

    private boolean isFinDeSemana(String fecha) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse(fecha);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
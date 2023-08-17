/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sc_202_2c2023j_g1;

/**
 *
 * @author Mercedes León
 */
public class Agenda {
    private static final int horarioInicio = 8;
    private static final int horarioFin = 7;

    private final Barbero[] barberos;
    private final Cliente[][] agenda;

    public Agenda(Barbero[] barberos) {
        this.barberos = barberos;
        this.agenda = new Cliente[barberos.length][horarioFin - horarioInicio + 1];
    }

    public boolean agregarCliente(Cliente cliente, Barbero barbero) {
        int horaAlmuerzo = Integer.parseInt(barbero.getHoraAlmuerzo().split(":")[0]);
        int horaInicio = horarioInicio;

        while (horaInicio <= horarioFin - cliente.getRangoHoras() + 1) {
            if (horaInicio == horaAlmuerzo) {
                horaInicio++;
                continue;
            }

            boolean espacioDisponible = true;
            for (int i = 0; i < cliente.getRangoHoras(); i++) {
                if (agenda[getIndexBarbero(barbero)][horaInicio - horarioInicio + i] != null) {
                    espacioDisponible = false;
                    break;
                }
            }

            if (espacioDisponible) {
                for (int i = 0; i < cliente.getRangoHoras(); i++) {
                    agenda[getIndexBarbero(barbero)][horaInicio - horarioInicio + i] = cliente;
                }
                return true;
            }

            horaInicio++;
        }

        return false;
    }

    public boolean eliminarCliente(Cliente cliente, Barbero barbero) {
        int horaInicio = horarioInicio;
        while (horaInicio <= horarioFin - cliente.getRangoHoras() + 1) {
            boolean esCliente = true;
            for (int i = 0; i < cliente.getRangoHoras(); i++) {
                if (agenda[getIndexBarbero(barbero)][horaInicio - horarioInicio + i] != cliente) {
                    esCliente = false;
                    break;
                }
            }

            if (esCliente) {
                for (int i = 0; i < cliente.getRangoHoras(); i++) {
                    agenda[getIndexBarbero(barbero)][horaInicio - horarioInicio + i] = null;
                }
                return true;
            }

            horaInicio++;
        }

        return false;
    }

    private int getIndexBarbero(Barbero barbero) {
        for (int i = 0; i < barberos.length; i++) {
            if (barbero == barberos[i]) {
                return i;
            }
        }
        return -1;
    }

    public void mostrarAgenda(Barbero barbero, String dia) {
        int diaInt = Integer.parseInt(dia);
        if (diaInt < 1 || diaInt > 7) {
            System.out.println("Día inválido. Ingrese un número del 1 al 7.");
            return;
        }

        System.out.println("Agenda del barbero " + barbero.getNombre() + " para el día " + dia + ":");

        for (int hora = horarioInicio; hora <= horarioFin; hora++) {
            if (hora == Integer.parseInt(barbero.getHoraAlmuerzo().split(":")[0])) {
                System.out.println("Tiempo de almuerzo ");
                continue;
            }

            int indexBarbero = getIndexBarbero(barbero);
            Cliente cliente = agenda[indexBarbero][hora - horarioInicio];

            if (cliente != null) {
                System.out.println(hora + ":00 - " + cliente.getNombre() + " (" + cliente.getTelefono() + ")");
            } else {
                System.out.println(hora + ":00 - ---VACIO---");
            }
        }
    }

    public double calcularRecaudacion(Barbero barbero, String dia) {
        int diaInt = Integer.parseInt(dia);
        if (diaInt < 1 || diaInt > 7) {
            System.out.println("Día inválido. Ingrese un número del 1 al 7.");
            return 0;
        }

        double recaudacion = 0;
        int indexBarbero = getIndexBarbero(barbero);

        for (int hora = horarioInicio; hora <= horarioFin; hora++) {
            Cliente cliente = agenda[indexBarbero][hora - horarioInicio];
            if (cliente != null) {
                double costoTotal = Servicios.calcularCostoTotal(esFinDeSemana(dia), cliente.getRangoHoras());
                cliente.setCostoTotal(costoTotal);
                recaudacion += costoTotal;
            }
        }

        return recaudacion;
    }

    private boolean esFinDeSemana(String dia) {
        int diaInt = Integer.parseInt(dia);
        return diaInt == 6 || diaInt == 7; //sábado es 6 y domingo es 7
    }


    
}


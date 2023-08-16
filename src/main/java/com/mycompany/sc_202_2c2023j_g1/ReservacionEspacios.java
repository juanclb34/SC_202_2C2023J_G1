package com.mycompany.sc_202_2c2023j_g1;


class ReservacionEspacios {
    private Barbero[] barberos;

    public ReservacionEspacios(Barbero[] barberos) {
        this.barberos = barberos;
    }

    public void realizarReservacion(Cliente cliente) {
        Barbero barberoDisponible = null;
        for (Barbero barbero : barberos) {
            if (barbero.estaDisponible(cliente.getDiaAtencion(), cliente.getRangoHoras())) {
                barberoDisponible = barbero;
                break;
            }
        }

        if (barberoDisponible != null) {
            double totalPagar = cliente.getPrecioHora() * cliente.getRangoHoras();
            System.out.println("¡Reservación exitosa!");
            System.out.println("Barbero asignado: " + barberoDisponible.getNombre());
            System.out.println("Total a pagar: " + totalPagar);
        } else {
            System.out.println("No hay barberos disponibles para la fecha y hora seleccionadas.");
        }
    }
}

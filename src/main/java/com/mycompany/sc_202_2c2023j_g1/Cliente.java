
package com.mycompany.sc_202_2c2023j_g1;

/**
 *
 * @author Mercedes León
 */
public class Cliente {
    private final String nombre;
    private final String telefono;
    private final String cita;
    private final int rangoHoras;
    private double costoTotal;

    public Cliente(String nombre, String telefono, String cita, int rangoHoras) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.cita = cita;
        this.rangoHoras = rangoHoras;
        this.costoTotal = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCita() {
        return cita;
    }

    public int getRangoHoras() {
        return rangoHoras;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
}

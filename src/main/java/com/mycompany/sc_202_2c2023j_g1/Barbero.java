
package com.mycompany.sc_202_2c2023j_g1;

/**
 *
 * @author Juan Carlos
 */
public class Barbero {
    
    private String nombre;
    private int horaAlmuerzo;

    public Barbero(String nombre, int horaAlmuerzo) {
        this.nombre = nombre;
        this.horaAlmuerzo = horaAlmuerzo;
    }

    // Métodos getter y setter para el nombre del barbero
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos getter y setter para la hora de almuerzo
    public int getHoraAlmuerzo() {
        return horaAlmuerzo;
    }

    public void setHoraAlmuerzo(int horaAlmuerzo) {
        this.horaAlmuerzo = horaAlmuerzo;
    }

    boolean tieneEspacioDisponible(String diaReservacion, String rangoHoras) {
        throw new UnsupportedOperationException("No es compatible");
    }

    boolean eliminarReservacion(String nombreCliente, String nombreBarbero, String diaReservacion) {
        throw new UnsupportedOperationException("No es compatible");
    }

    String getClienteEnHora(String diaReservacion, String hora) {
        throw new UnsupportedOperationException("No es compatible"); 
    }

    String getTelefonoCliente(String diaReservacion, String hora) {
        throw new UnsupportedOperationException("No es compatible");
    }
}

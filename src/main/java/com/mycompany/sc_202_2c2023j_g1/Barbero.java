
package com.mycompany.sc_202_2c2023j_g1;

/**
 *
 * @author Juan Carlos
 */
public class Barbero {
    
       private String nombre;
    private int horaAlmuerzo;
    private Iterable<String> horarios;

    public Barbero(String nombre, int horaAlmuerzo) {
        this.nombre = nombre;
        this.horaAlmuerzo = horaAlmuerzo;
    }

    // Getters y setters 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoraAlmuerzo() {
        return horaAlmuerzo;
    }

    public void setHoraAlmuerzo(int horaAlmuerzo) {
        this.horaAlmuerzo = horaAlmuerzo;
    }
     public boolean estaDisponible(String diaAtencion, int rangoHoras) {
        for (String horario : horarios) {
            if (horario.equalsIgnoreCase(diaAtencion) && rangoHoras <= 8) {
                return true;
            }
        }
        return false;
    }
}



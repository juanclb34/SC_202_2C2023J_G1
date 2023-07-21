
package com.mycompany.sc_202_2c2023j_g1;

/**
 *
 * @author Juan Carlos
 */
public class Barbero {
    
    private String nombre;
    private String horaAlmuerzo;
    private String citas;

    public Barbero(String nombre, String horaAlmuerzo) {
        this.nombre = nombre;
        this.horaAlmuerzo = horaAlmuerzo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getHoraAlmuerzo() {
        return horaAlmuerzo;
    }
}


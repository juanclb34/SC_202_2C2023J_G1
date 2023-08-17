package com.mycompany.sc_202_2c2023j_g1;

/**
 *
 * @author Juan Carlos
 */


public class Barbero {
    
    //Atributos
    private String nombre;
    private int horaAlmuerzo;
    
    //Uso de getters y setters
    public Barbero(String nombre, int horaAlmuerzo) {
        this.nombre = nombre;
        this.horaAlmuerzo = horaAlmuerzo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHoraAlmuerzo() {
        return horaAlmuerzo;
    }

    public void setHoraAlmuerzo(int horaAlmuerzo) {
        this.horaAlmuerzo = horaAlmuerzo;
    }
}

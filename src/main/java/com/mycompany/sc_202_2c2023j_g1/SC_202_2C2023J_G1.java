/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sc_202_2c2023j_g1;

/**
 *
 * @author Juan Carlos
 */
public class SC_202_2C2023J_G1 {

    public static void main(String[] args){

        Barbero[] barberos = new Barbero[5];

        barberos[0] = new Barbero("Barbero 1", 13);
        barberos[1] = new Barbero("Barbero 2", 12);
        barberos[2] = new Barbero("Barbero 3", 14);
        barberos[3] = new Barbero("Barbero 4", 13);
        barberos[4] = new Barbero("Barbero 5", 12);

        for (Barbero barbero : barberos){
            System.out.println("Nombre del barbero: " + barbero.getNombre());
            System.out.println("Hora de almuerzo: " + barbero.getHoraAlmuerzo());
            System.out.println();
        }
    }  
}
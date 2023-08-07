/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sc_202_2c2023j_g1;

/**
 *
 * @author Usuario
 */
public class SC_202_2C2023J_G1 {

    public static void main(String[] args){
        
        int numBarberos = 5;
        int horaInicio = 8;
        int horaFin = 18;

        Barbero[] barberos = new Barbero[numBarberos];
        barberos[0] = new Barbero("Barbero 1", 12); // Ejemplo: el Barbero 1 sale a almorzar a las 12PM
        barberos[1] = new Barbero("Barbero 2", 1);  // Ejemplo: el Barbero 1 sale a almorzar a las 1PM
        barberos[2] = new Barbero("Barbero 3", 2);  // Ejemplo: el Barbero 1 sale a almorzar a las 2PM
        barberos[3] = new Barbero("Barbero 4", 3);  // Ejemplo: el Barbero 1 sale a almorzar a las 3PM
        barberos[4] = new Barbero("Barbero 5", 4);  // Ejemplo: el Barbero 1 sale a almorzar a las 4PM
        

        boolean[][] calendario = new boolean[numBarberos][horaFin - horaInicio + 1];
        for (int i = 0; i < numBarberos; i++) {
            for (int j = 0; j < horaFin - horaInicio + 1; j++) {
                calendario[i][j] = true; // Todas las citas disponibles inicialmente
            }
        }

    }
}

    
    


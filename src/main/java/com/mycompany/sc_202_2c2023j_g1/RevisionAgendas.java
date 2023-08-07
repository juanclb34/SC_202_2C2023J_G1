/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sc_202_2c2023j_g1;

/**
 *
 * @author Mercedes León
 */
import java.util.Scanner;

public class RevisionAgendas{
    
    private static final int NUM_BARBEROS = 5;
    private static final int HORARIO_INICIO = 8;
    private static final int HORARIO_FIN = 18;
    private static final double PRECIO_HORA_SEMANA = 2500; 
    private static final double PRECIO_HORA_FINDE = 3000;
    private static final double IVA = 0.13;
    
    private Barbero[] barberos;
    private boolean[][] calendario;
    
    
    public RevisionAgendas(){
        barberos = new Barbero[NUM_BARBEROS];
           
        calendario = new boolean[NUM_BARBEROS][HORARIO_FIN - HORARIO_INICIO];
        
        }
    
    public void mostrarAgenda(int barberoIndex,int dia){
    
    Barbero barbero = barberos[barberoIndex];
            System.out.println("Agenda de" + barbero.getNombre() + " para el día " + dia + ":");
            
            for (int hora = HORARIO_INICIO; hora < HORARIO_FIN; hora++) {
                System.out.println(hora + ":00\t" );
                
                if (hora == barbero.getHoraAlmuerzo()) {
                    System.out.println("HORA DE ALMUERZO");
                    
                    } else{
                    int horaIndex = hora - HORARIO_INICIO;
                    
                    if (calendario[barberoIndex][horaIndex]) {
                        
                        //Imprimir nombre de cliente y teléfono
                        
                        System.out.println("Nombre:" + "cliente" + hora + "\tTeléfono:" + "123456789");
                         
                    }else{
                        System.out.println("---VACIO---");
                        
                    }
                }   
        }
    }
    
    
    public double calcularMontoRecaudar(int barberoIndex, int dia){
        double total = 0;
        
        for (int hora = HORARIO_INICIO; hora < HORARIO_FIN; hora++) {
            int horaIndex = hora - HORARIO_INICIO;
            if (calendario [barberoIndex][horaIndex]){
                total+= calcularPrecio(hora);
                    
            }  
        }
        
        return total;
        
    }
    
    private double calcularPrecio(int hora){
        if (hora >= 16 || hora <= 18) {
            return(PRECIO_HORA_FINDE * 2)*(1+IVA);    
        }else{
            return(PRECIO_HORA_SEMANA * 2)*(1+IVA);
         
        }
    }
}


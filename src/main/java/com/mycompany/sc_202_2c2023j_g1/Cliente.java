/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sc_202_2c2023j_g1;

import java.util.Calendar;

/**
 *
 * @author Mercedes León
 */
<<<<<<< HEAD
import java.util.Scanner;
=======
public class Cliente {
    private final String nombre;
    private final String telefono;
    private final String cita;
    private final int rangoHoras;
    private double costoTotal;
    
>>>>>>> origin/main

class Cliente {
    private String nombre;
    private String telefono;
    private String diaAtencion;
    private int rangoHoras;
    private double precioHora;

    public Cliente(String nombre, String telefono, String diaAtencion, int rangoHoras) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.diaAtencion = diaAtencion;
        this.rangoHoras = rangoHoras;
        this.precioHora = calcularPrecioHora(diaAtencion);
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDiaAtencion() {
        return diaAtencion;
    }

    public int getRangoHoras() {
        return rangoHoras;
    }

    public double getPrecioHora() {
        return precioHora;
    }

    private double calcularPrecioHora(String diaAtencion) {
        double precioBase = diaAtencion.equalsIgnoreCase("sábado") || diaAtencion.equalsIgnoreCase("domingo") ? 3000 : 2500;
        double precioConIVA = precioBase * 1.13;
        return precioConIVA;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre del cliente: " + nombre);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Día de atención: " + diaAtencion);
        System.out.println("Rango de horas: " + rangoHoras);
        System.out.println("Precio por hora: " + precioHora);
    }
    
    

    Calendar getFechaCita() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sc_202_2c2023j_g1;

/**
 *
 * @author Familia
 */
public class Servicios {
    private static final double PRECIO_SEMANA = 2500; // Precio por hora durante la semana
    private static final double PRECIO_FIN_DE_SEMANA = 3000; // Precio por hora durante el fin de semana
    private static final double IVA = 0.13; // Tasa de impuesto IVA del 13%

    private double precioHora;
    private double precioConIVA;

    public Servicios(double precioHora) {
        this.precioHora = precioHora;
        this.precioConIVA = calcularPrecioConIVA();
    }

    public double getPrecioConIVA() {
        return precioConIVA;
    }

    private double calcularPrecioConIVA() {
        double precioConIVA = precioHora * (1 + IVA);
        return precioConIVA;
    }

}


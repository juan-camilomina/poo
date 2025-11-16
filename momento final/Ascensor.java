/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poo_final_ascensor;

/**
 *
 * @author orozc
 */// 5. Ascensor.java
public class Ascensor {
    private int pisoActual;
    private int totalPisos;
    private Puerta puerta;
    private BotonAscensor[] botonesInternos;
    private boolean enMovimiento;
    private String direccion; // "subiendo", "bajando", "parado"

    public Ascensor(int totalPisos) {
        this.totalPisos = totalPisos;
        this.pisoActual = 1;
        this.puerta = new Puerta();
        this.botonesInternos = new BotonAscensor[totalPisos];
        for (int i = 0; i < totalPisos; i++) {
            botonesInternos[i] = new BotonAscensor(i + 1);
        }
        this.enMovimiento = false;
        this.direccion = "parado";
    }

    public void moverA(int pisoDestino) {
        if (pisoDestino < 1 || pisoDestino > totalPisos) return;

        System.out.println("🚀 Ascensor moviéndose del piso " + pisoActual + " al " + pisoDestino);
        enMovimiento = true;
        direccion = (pisoDestino > pisoActual) ? "subiendo" : "bajando";

        // Simular movimiento
        while (pisoActual != pisoDestino) {
            pisoActual += (pisoDestino > pisoActual) ? 1 : -1;
            System.out.println("📍 Piso actual: " + pisoActual);
            try { Thread.sleep(800); } catch (Exception e) {}
        }

        enMovimiento = false;
        direccion = "parado";
        System.out.println("🛑 Ascensor detenido en piso " + pisoActual);
        puerta.abrir();
    }

    public void presionarBotonInterno(int piso) {
        if (piso >= 1 && piso <= totalPisos) {
            botonesInternos[piso - 1].presionar();
        }
    }

    public void cancelarBotonInterno(int piso) {
        botonesInternos[piso - 1].cancelarIluminacion();
    }

    public Puerta getPuerta() { return puerta; }
    public int getPisoActual() { return pisoActual; }
    public String getDireccion() { return direccion; }
    public boolean estaEnMovimiento() { return enMovimiento; }
}
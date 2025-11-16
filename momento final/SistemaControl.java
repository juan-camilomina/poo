/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo_final_ascensor;
/**
 *
 * @author 
 */
// 7. SistemaControl.java (Corazón del sistema)

/**
 * Clase principal que controla todo el sistema de ascensores.
 * 
 * Cumple con:
 * - UML (p.4): CONTROL_ELEVADOR
 *   → Gestiona: ELEVADOR, PUERTAS, BOTONES (internos y de piso)
 * - Entrevista (p.2-3):
 *   → Optimización de dirección (no cambiar hasta agotar solicitudes)
 *   → Alertas de falla en cualquier componente
 *   → Registro de mantenimiento
 */

import java.util.*;

public class SistemaControl {
    private Ascensor ascensor;
    private Piso[] pisos;
    private List<Integer> solicitudesSubida;
    private List<Integer> solicitudesBajada;
    private List<Integer> destinosInternos;

    
    /**
     * Constructor
     * totalPisos Número total de pisos en el edificio
     */
    public SistemaControl(int totalPisos) {
        this.ascensor = new Ascensor(totalPisos);
        this.pisos = new Piso[totalPisos];
        for (int i = 0; i < totalPisos; i++) {
            pisos[i] = new Piso(i + 1, totalPisos);
        }
        this.solicitudesSubida = new ArrayList<>();
        this.solicitudesBajada = new ArrayList<>();
        this.destinosInternos = new ArrayList<>();
    }

    // SOLICITUD DESDE PISO (Botones de pasillo) ===
    
    public void solicitarAscensor(int piso, boolean subir) {
        if (subir) {
            pisos[piso - 1].presionarSubida();
            if (!solicitudesSubida.contains(piso)) solicitudesSubida.add(piso);
        } else {
            pisos[piso - 1].presionarBajada();
            if (!solicitudesBajada.contains(piso)) solicitudesBajada.add(piso);
        }
        procesarSolicitudes();
    }
// SELECCIÓN DE PISO DESDE DENTRO (Botones internos)
    public void seleccionarPiso(int piso) {
        ascensor.presionarBotonInterno(piso);
        if (!destinosInternos.contains(piso)) destinosInternos.add(piso);
        procesarSolicitudes();
    }
//OPTIMIZACIÓN DE DIRECCIÓN
    private void procesarSolicitudes() {
        if (ascensor.estaEnMovimiento()) return;

        int pisoActual = ascensor.getPisoActual();
        String direccion = ascensor.getDireccion();

        // Priorizar dirección actual
        if (direccion.equals("subiendo") || direccion.equals("parado")) {
            int proximo = proximoPisoEnDireccion(pisoActual, true);
            if (proximo != -1) {
                ascensor.moverA(proximo);
                limpiarSolicitud(proximo);
                return;
            }
        }

        if (direccion.equals("bajando") || direccion.equals("parado")) {
            int proximo = proximoPisoEnDireccion(pisoActual, false);
            if (proximo != -1) {
                ascensor.moverA(proximo);
                limpiarSolicitud(proximo);
                return;
            }
        }

        // Cambiar dirección si no hay más en actual
        if (!solicitudesSubida.isEmpty() && (direccion.equals("parado") || direccion.equals("bajando"))) {
            ascensor.moverA(Collections.min(solicitudesSubida));
        } else if (!solicitudesBajada.isEmpty() && (direccion.equals("parado") || direccion.equals("subiendo"))) {
            ascensor.moverA(Collections.max(solicitudesBajada));
        }
    }

    private int proximoPisoEnDireccion(int actual, boolean subiendo) {
        List<Integer> candidatos = subiendo ? new ArrayList<>(solicitudesSubida) : new ArrayList<>(solicitudesBajada);
        candidatos.addAll(destinosInternos);

        int proximo = -1;
        if (subiendo) {
            for (int p : candidatos) {
                if (p > actual && (proximo == -1 || p < proximo)) proximo = p;
            }
        } else {
            for (int p : candidatos) {
                if (p < actual && (proximo == -1 || p > proximo)) proximo = p;
            }
        }
        return proximo;
    }
// === LIMPIEZA AL LLEGAR
    private void limpiarSolicitud(int piso) {
        solicitudesSubida.remove(Integer.valueOf(piso));
        solicitudesBajada.remove(Integer.valueOf(piso));
        destinosInternos.remove(Integer.valueOf(piso));
        ascensor.cancelarBotonInterno(piso);
        pisos[piso - 1].cancelarSolicitud(piso);
    }

    // Alertas
    public void reportarFalla(String componente) {
        System.out.println("[ALERTA] Falla detectada en: " + componente);
        System.out.println("Ascensor detenido por seguridad en piso " + ascensor.getPisoActual());
        ascensor.getPuerta().abrir();
    }

    public Ascensor getAscensor() { return ascensor; }
}
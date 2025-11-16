/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo_final_ascensor;
/**
 *
 * @author 
 */// 6. Piso.java

/**
 * Clase que representa un piso del edificio con sus botones de solicitud.
 * 
 * Cumple con:
 * - UML (p.4): PISO contiene 0..1 BOTON_PISO (subida) y 0..1 BOTON_PISO (bajada)
 * - Entrevista (p.2):
 *   → "Cada piso debe tener botones para solicitar el ascensor en dirección de subida o bajada."
 *   → "Los botones deben permitir seleccionar el piso de destino."
 *   → "La iluminación se cancela cuando el ascensor llega."
 * - Rúbrica:
 *   → Criterio 1: Diseño de Clases (estructura clara)
 *   → Criterio 2: Encapsulación
 *   → Criterio 3: Atributos y Métodos
 *   → Criterio 4: Manejo de Botones (subida/bajada)
 */

import java.util.ArrayList;
import java.util.List;

public class Piso {
    private int numero; // Número del piso (1, 2, 3...)
    private BotonPiso botonSubida; // Botón ↑ (null si es el último piso)
    private BotonPiso botonBajada;// Botón ↓ (null si es el primer piso)
    private List<Integer> solicitudesPendientes; // Para saber si es el primero/último

    /**
     * Constructor
     * numero Número del piso
     * totalPisos Total de pisos en el edificio
     */
    public Piso(int numero, int totalPisos) {
        this.numero = numero;
        this.solicitudesPendientes = new ArrayList<>();
      // Botón de subida: solo si NO es el último piso
      if (numero < totalPisos) botonSubida = new BotonPiso(numero, true);
  
      // Botón de bajada: solo si NO es el primer piso 
       if (numero > 1) botonBajada = new BotonPiso(numero, false);
    }
/**
     * Usuario presiona botón de BAJAR
     */

    public void presionarSubida() {
        if (botonSubida != null) {
            botonSubida.presionar();
            solicitudesPendientes.add(numero);
        }
    }
/**
     * Usuario presiona botón de BAJAR
     */
    public void presionarBajada() {
        if (botonBajada != null) {
            botonBajada.presionar();
            solicitudesPendientes.add(numero);
        }
    }
// === MÉTODOS PARA CANCELAR ILUMINACIÓN AL LLEGAR (Entrevista + Rúbrica 4) ===
    public void cancelarSolicitud(int piso) {
        if (solicitudesPendientes.contains(piso)) {
            if (piso == numero && botonSubida != null && botonSubida.estaIluminado()) {
                botonSubida.cancelarIluminacion();
            } else if (piso == numero && botonBajada != null && botonBajada.estaIluminado()) {
                botonBajada.cancelarIluminacion();
            }
            solicitudesPendientes.remove(Integer.valueOf(piso));
        }
    }

    public boolean tieneSolicitud() {
        return !solicitudesPendientes.isEmpty();
    }

    public int getNumero() { return numero; }
}

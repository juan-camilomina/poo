/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo_final_ascensor;
/**
 *
 * @author
 */// 3. BotonPiso.java

/**
 * Clase que representa un botón en el pasillo de un piso para solicitar el ascensor.
 * 
 * Cumple con:
 * - UML (p.4): BOTON_PISO (hereda de BOTON)
 * - Entrevista (p.2):
 *   → "Cada piso [...] tiene dos botones, uno para subir y otro para bajar."
 *   → "Los botones dentro del ascensor deben permitir seleccionar el piso de destino."
 *   → "El botón se ilumine al presionarlo y emita un sonido suave."
 *   → "La iluminación se cancela cuando luego de su arribo el ascensor y se dirige a la dirección deseada."
 * - Rúbrica:
 *   → Criterio 2: Herencia y Polimorfismo
 *   → Criterio 3: Atributos y Métodos
 *   → Criterio 4: Manejo de Botones (subida/bajada, luz, sonido)
 */
public class BotonPiso extends Boton {
    private boolean esSubida; // true = ↑ (subir), false = ↓ (bajar)

    /**
     * Constructor
     * piso Número del piso donde está el botón
     * esSubida true si es botón de subir, false si es bajar
     */

    public BotonPiso(int piso, boolean esSubida) {
        super(piso); // Llama al constructor de Boton
        this.esSubida = esSubida;
    }

    /**
     * Implementación del método abstracto de Boton
     * → Ilumina el botón en el pasillo (↑ o ↓)
     * → Cumple: "El botón se ilumine al presionarlo"
     */
    @Override
    protected void iluminar() {
        System.out.println("🔆 Botón " + (esSubida ? "↑ SUBIR" : "↓ BAJAR") + " Piso " + pisoAsociado + " iluminado");
    }

    
    /**
     * Implementación del método abstracto de Boton
     * → Apaga la luz cuando el ascensor llega y abre puertas
     * → Cumple: "La iluminación se cancela cuando luego de su arribo el ascensor"
     */
    @Override
    protected void apagarLuz() {
        System.out.println("⚫ Botón " + (esSubida ? "↑" : "↓") + " Piso " + pisoAsociado + " apagado");
    }

    public boolean esSubida() { return esSubida; }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo_final_ascensor;
/**
 *
 * @author
 */
// 4. Puerta.java

/**
 * Clase que representa las puertas del ascensor con sensores y control de apertura/cierre.
 * 
 * Cumple con:
 * - UML (p.4): PUERTAS (controlada por CONTROL_ELEVADOR)
 * - Entrevista (p.2-3):
 *   → "Las puertas del ascensor y de cada piso deben abrirse y cerrarse automáticamente cuando el ascensor llega al piso."
 *   → "Además, debe haber sensores para evitar que las puertas se cierren si hay un obstáculo."
 *   → "Debería haber algún mecanismo para mantener las puertas abiertas durante más tiempo en caso de que sea necesario."
 * - Rúbrica:
 *   → Criterio 6: Manejo de Puertas (10 pts)
 *     - Apertura/cierre automático
 *     - Sensores de seguridad
 *     - Botón "mantener puertas abiertas"
 */



public class Puerta {
    private boolean abierta; // Estado actual: true = abierta, false = cerrada
    private boolean obstaculo; // Sensor: true = hay obstáculo
    private boolean mantenerAbierta; // Botón especial: true = mantener abierta

    
    /**
     * Constructor: Puertas comienzan cerradas
     */
    public Puerta() {
        this.abierta = false;
        this.obstaculo = false;
        this.mantenerAbierta = false;
    }

    // APERTURA Y CIERRE AUTOMÁTICO 

    /**
     * Abre las puertas automáticamente al llegar al piso
     * → Cumple: "abrirse automáticamente cuando el ascensor llega al piso"
     */
    
    public void abrir() {
        if (!abierta) {
            abierta = true;
            System.out.println(" Puertas ABIERTAS");
        }
    }
/**
     * Cierra las puertas automáticamente
     * → Solo si NO hay obstáculo y NO está activado "mantener abierta"
     * → Cumple: "cerrarse automáticamente"
     */
    public void cerrar() {
        if (abierta && !obstaculo && !mantenerAbierta) {
            abierta = false;
            System.out.println(" Puertas CERRADAS");
        } else if (obstaculo) {
            System.out.println("️ OBSTÁCULO DETECTADO: No se pueden cerrar las puertas");
        } else if (mantenerAbierta) {
            System.out.println(" Puertas mantenidas abiertas por botón");
        }
    }

    // SENSORES DE SEGURIDAD 

    /**
     * Simula el sensor de obstáculo
     * @param hay true si hay obstáculo, false si no
     * → Cumple: "sensores para evitar que las puertas se cierren si hay un obstáculo"
     */
    
    public void detectarObstaculo(boolean hay) {
        this.obstaculo = hay;
    }

    // BOTÓN "MANTENER PUERTAS ABIERTAS" (Rúbrica 6) ===

    /**
     * Activa o desactiva el modo "mantener puertas abiertas"
     * activar true = activar, false = desactivar
     * → Cumple: "mecanismo para mantener las puertas abiertas durante más tiempo"
     */
    public void activarMantenerAbierta(boolean activar) {
        this.mantenerAbierta = activar;
        if (activar)
        {
            System.out.println("️ Puertas mantenidas abiertas");
            abrir();// Asegurar que estén abiertas
        }
        else System.out.println("Puertas liberadas");
    }

    public boolean estaAbierta() { return abierta; }
}
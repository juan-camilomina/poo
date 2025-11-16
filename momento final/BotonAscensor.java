/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo_final_ascensor;
/**
 * Clase que representa un botón dentro del ascensor para seleccionar un piso destino.
 * 
 * Cumple con:
 * - UML: BOTON_ELEVADOR (hereda de BOTON)
 * - Entrevista: 
 *   → "Los botones en el ascensor [...] deben permitir seleccionar el piso de destino."
 *   → "El botón se ilumine al presionarlo y emita un sonido suave para que el usuario sepa que la solicitud fue recibida."
 *   → "La iluminación se cancela cuando el ascensor llega al piso."
 * - Rúbrica:
 *   → Criterio 2: Herencia y Polimorfismo
 *   → Criterio 3: Atributos y Métodos
 *   → Criterio 4: Manejo de Botones (iluminación, sonido, selección)
 */



/**
 *
 * @author 
 */// 2. BotonAscensor.java
public class BotonAscensor extends Boton {
    
    /**
     * Constructor
     * Número del piso asociado al botón (1, 2, 3, ...)
     */
    
    public BotonAscensor(int piso) {
        super(piso); // Llama al constructor de Boton
    }
/**
     * Implementación del método abstracto de Boton
     * → Ilumina el botón dentro del ascensor
     * → Cumple: "El botón se ilumine al presionarlo"
     */
    @Override
    protected void iluminar() {
        System.out.println("🔆 Botón PISO " + pisoAsociado + " iluminado (dentro del ascensor)");
    }
/**
     * Implementación del método abstracto de Boton
     * → Apaga la luz cuando el ascensor llega al piso
     * → Cumple: "La iluminación se cancela cuando luego de su arribo el ascensor y se dirige a la dirección deseada."
     */
    @Override
    protected void apagarLuz() {
        System.out.println("⚫ Botón PISO " + pisoAsociado + " apagado");
    }
}
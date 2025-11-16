/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 * Clase abstracta base para todos los botones del sistema de ascensor.
 * Cumple con:
 * - UML: Clase padre de Boton_Elevador y Boton_Piso
 * - Rúbrica: Herencia, encapsulación, métodos abstractos, indicadores visuales/sonoros
 * - Requerimientos: Iluminación, sonido, cancelación al llegar
 */


package com.mycompany.poo_final_ascensor;

/**
 *
 * @author 
 */// 1. Boton.java (Clase abstracta base)
public abstract class Boton {
    protected boolean iluminado;// Estado de la luz
    protected int pisoAsociado;// Piso asociado

    public Boton(int piso) {
        this.pisoAsociado = piso;
        this.iluminado = false;
    }

    /**
     * Simula la presión del botón.
     * - Ilumina si no está iluminado
     * - Emite sonido de confirmación
     * - Evita doble presión
     */
    
    public void presionar() {
        if (!iluminado) {
            iluminado = true;
            iluminar(); // Método abstracto → polimorfismo
            emitirSonido();// Requerimiento: sonido suave
        }
    }
/**
     * Cancela la iluminación cuando el ascensor llega al piso.
     * - Apaga luz
     * - Actualiza estado
     */
    
    public void cancelarIluminacion() {
        iluminado = false;
        apagarLuz(); // Método abstracto → polimorfismo
    }
/** 
     * Define cómo se ilumina el botón.
     * Implementado diferente en BotonAscensor y BotonPiso
     */
    protected abstract void iluminar();
    
    /**
     * Define cómo se apaga la luz.
     */
    protected abstract void apagarLuz();
    
    /**
     * Emite sonido de confirmación al presionar.
     * Requerimiento: "emita un sonido suave"
     */
    protected void emitirSonido() {
        System.out.println("♪ *beep* Botón presionado (Piso " + pisoAsociado + ")");
    }

    public int getPiso() { return pisoAsociado; }
    public boolean estaIluminado() { 
        return iluminado; }
}
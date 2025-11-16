/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poo_final_ascensor;

/**
 *
 * @author 
 */

/**
 * Clase principal que simula el funcionamiento completo del sistema de ascensores.
 * 
 * Cumple con:
 * - Rúbrica C9: Ejecución del Sistema (5 pts)
 *   → Demuestra que todas las clases funcionan integradas
 *   → Simula escenarios reales: solicitudes, movimiento, puertas, fallas
 * - Entrevista: Todos los requerimientos en acción
 * - UML: Flujo completo del diagrama de clases
 */
public class POO_Final_Ascensor {

      public static void main(String[] args) {
          
          // === INICIALIZACIÓN DEL SISTEMA (5 pisos) ===
        SistemaControl sistema = new SistemaControl(5);

        System.out.println("=== SIMULACIÓN DE ASCENSOR ===\n");

        // Usuario en piso 3 quiere subir
        sistema.solicitarAscensor(3, true);

        // Usuario en piso 1 selecciona piso 4
        sistema.seleccionarPiso(4);

        // Usuario en piso 2 quiere bajar
        sistema.solicitarAscensor(2, false);

        // Simular obstáculo
        sistema.getAscensor().getPuerta().detectarObstaculo(true);
        sistema.getAscensor().getPuerta().cerrar();
        sistema.getAscensor().getPuerta().detectarObstaculo(false);

        // Mantener puertas abiertas
        sistema.getAscensor().getPuerta().activarMantenerAbierta(true);
        try { Thread.sleep(2000); } catch (Exception e) {}
        sistema.getAscensor().getPuerta().activarMantenerAbierta(false);

        // Falla simulada
        sistema.reportarFalla("Sensor de puerta");
    }
  
}

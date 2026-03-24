package SimulacionSupermercado;

import java.util.*;

public class SimulacionSupermercado {

    public static void main(String[] args) {

        Random rand = new Random();

        int tiempoTotal = 7 * 60; // 7 horas
        int tiempo = 0;

        Queue<Integer> fila = new LinkedList<>();

        int[] cajas = new int[4];
        boolean caja4Activa = false;

        int clientesAtendidos = 0;
        int sumaFila = 0;
        int maxFila = 0;
        int maxEspera = 0;
        int tiempoCaja4 = 0;

        while (tiempo < tiempoTotal) {

            // 🔥 MUCHOS clientes (para generar fila)
            if (rand.nextDouble() < 0.99) {
                fila.add(tiempo);
            }

            // Activar caja 4 (más sensible)
            if (fila.size() > 10) {
                caja4Activa = true;
            }
            if (fila.size() < 3) {
                caja4Activa = false;
            }

            // Asignar clientes a cajas
            for (int i = 0; i < 4; i++) {

                if (i == 3 && !caja4Activa) continue;

                if (cajas[i] <= 0 && !fila.isEmpty()) {

                    int llegada = fila.poll();
                    int espera = tiempo - llegada;

                    if (espera > maxEspera) {
                        maxEspera = espera;
                    }

                    clientesAtendidos++;

                    // 🔥 Cajas más lentas (más real)
                    if (i == 0) cajas[i] = 3 + rand.nextInt(3); // 3-5
                    if (i == 1) cajas[i] = 4 + rand.nextInt(4); // 4-7
                    if (i == 2) cajas[i] = 4 + rand.nextInt(3); // 4-6
                    if (i == 3) cajas[i] = 4 + rand.nextInt(4); // 4-7
                }
            }

            // Reducir tiempos
            for (int i = 0; i < 4; i++) {
                if (cajas[i] > 0) {
                    cajas[i]--;
                }
            }

            // Estadísticas
            sumaFila += fila.size();

            if (fila.size() > maxFila) {
                maxFila = fila.size();
            }

            if (caja4Activa) {
                tiempoCaja4++;
            }

            tiempo++;
        }

        double promedioFila = (double) sumaFila / tiempoTotal;

        // RESULTADOS
        System.out.println("Clientes atendidos: " + clientesAtendidos);
        System.out.println("Tamaño medio de fila: " + promedioFila);
        System.out.println("Tamaño maximo de fila: " + maxFila);
        System.out.println("Tiempo maximo de espera: " + maxEspera + " minutos");
        System.out.println("Tiempo caja 4 abierta: " + tiempoCaja4 + " minutos");
    }
}
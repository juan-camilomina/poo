package SimulacionCarritos;

import java.util.*;

public class SimulacionCarritos {

    public static void main(String[] args) {

        Random rand = new Random();

        int tiempoTotal = 200; // tiempo de simulación

        int carritosDisponibles = 25;

        Queue<Integer> cola1 = new LinkedList<>();
        Queue<Integer> cola2 = new LinkedList<>();
        Queue<Integer> cola3 = new LinkedList<>();

        int[] cajas = new int[3];

        int clientesAtendidos = 0;
        int clientesEsperandoCarrito = 0;

        for (int tiempo = 0; tiempo < tiempoTotal; tiempo++) {

            // Llegan clientes
            if (rand.nextDouble() < 0.8) {

                if (carritosDisponibles > 0) {
                    carritosDisponibles--;

                    // Cliente va a comprar (tiempo aleatorio)
                    int tiempoCompra = 2 + rand.nextInt(5);

                    // Elegir la cola más corta
                    if (cola1.size() <= cola2.size() && cola1.size() <= cola3.size()) {
                        cola1.add(tiempoCompra);
                    } else if (cola2.size() <= cola1.size() && cola2.size() <= cola3.size()) {
                        cola2.add(tiempoCompra);
                    } else {
                        cola3.add(tiempoCompra);
                    }

                } else {
                    clientesEsperandoCarrito++;
                }
            }

            // Atender en cajas
            for (int i = 0; i < 3; i++) {

                if (cajas[i] <= 0) {

                    Queue<Integer> cola = (i == 0) ? cola1 : (i == 1) ? cola2 : cola3;

                    if (!cola.isEmpty()) {
                        cajas[i] = cola.poll();
                        clientesAtendidos++;
                        carritosDisponibles++; // devuelve carrito
                    }
                }
            }

            // Reducir tiempos en cajas
            for (int i = 0; i < 3; i++) {
                if (cajas[i] > 0) {
                    cajas[i]--;
                }
            }
        }

        // Resultados
        System.out.println("Clientes atendidos: " + clientesAtendidos);
        System.out.println("Clientes sin carrito (esperaron): " + clientesEsperandoCarrito);
        System.out.println("Carritos disponibles al final: " + carritosDisponibles);
        System.out.println("Clientes en cola 1: " + cola1.size());
        System.out.println("Clientes en cola 2: " + cola2.size());
        System.out.println("Clientes en cola 3: " + cola3.size());
    }
}
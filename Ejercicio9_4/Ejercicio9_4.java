package Ejercicio9_4;

import java.util.Stack;

public class Ejercicio9_4 {

    public static void main(String[] args) {

        // Crear 5 pilas
        Stack<Integer> P1 = new Stack<>();
        Stack<Integer> P2 = new Stack<>();
        Stack<Integer> P3 = new Stack<>();
        Stack<Integer> P4 = new Stack<>();
        Stack<Integer> P5 = new Stack<>();

        // Datos de prueba (i, j)
        int[][] datos = {
            {1, 10},
            {2, 20},
            {-1, 1},
            {3, 30},
            {1, 50},
            {-3, 1}
        };

        for (int[] par : datos) {
            int i = par[0];
            int j = par[1];

            int indice = Math.abs(i);

            Stack<Integer> pila = null;

            switch (indice) {
                case 1: pila = P1; break;
                case 2: pila = P2; break;
                case 3: pila = P3; break;
                case 4: pila = P4; break;
                case 5: pila = P5; break;
            }

            if (i > 0) {
                pila.push(j);
            } else {
                for (int k = 0; k < j; k++) {
                    if (!pila.isEmpty()) {
                        pila.pop();
                    }
                }
            }
        }

        // Mostrar resultado
        System.out.println("Contenido de las pilas:");
        System.out.println("P1: " + P1);
        System.out.println("P2: " + P2);
        System.out.println("P3: " + P3);
        System.out.println("P4: " + P4);
        System.out.println("P5: " + P5);
    }
}
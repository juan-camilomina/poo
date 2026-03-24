package SistemaGalacticExpress;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();

        //  Paso 1: Arreglo original
        int[] energiaContenedores = new int[12];

        System.out.println("Arreglo original:");
        for (int i = 0; i < energiaContenedores.length; i++) {
            energiaContenedores[i] = rand.nextInt(101) + 50;
            System.out.print(energiaContenedores[i] + " ");
        }

        //  Filtrar múltiplos de 10
        ArrayList<Integer> filtrados = new ArrayList<>();

        for (int valor : energiaContenedores) {
            if (valor % 10 == 0) {
                filtrados.add(valor);
            }
        }

        // IMPRIMIR FILTRADOS (LO QUE TE FALTABA)
        System.out.println("\n\nValores filtrados (multiplos de 10):");
        System.out.println(filtrados);

        //  Paso 2: Matriz 3x3
        int[][] mapaCarga = new int[3][3];
        int index = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (index < filtrados.size()) {
                    mapaCarga[i][j] = filtrados.get(index++);
                } else {
                    mapaCarga[i][j] = -1;
                }
            }
        }

        // IMPRIMIR MATRIZ (LO QUE TE FALTABA)
        System.out.println("\nMapa de carga:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(mapaCarga[i][j] + "\t");
            }
            System.out.println();
        }

        //  Paso 3: Manifiesto
        Suministro[] manifiesto = new Suministro[9];
        int pos = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                int valor = mapaCarga[i][j];

                if (valor != -1) {
                    String prioridad = (valor > 100) ? "ALTA" : "ESTÁNDAR";
                    manifiesto[pos] = new Suministro("C-" + i + "-" + j, valor, prioridad);
                } else {
                    manifiesto[pos] = null;
                }

                pos++;
            }
        }

        // Mostrar manifiesto
        System.out.println("\nManifiesto de vuelo:");

        for (Suministro s : manifiesto) {
            if (s != null) {
                System.out.println(s);
            } else {
                System.out.println("VACÍO");
            }
        }
    }
}
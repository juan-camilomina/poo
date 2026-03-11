package galactic;

import java.util.Random;
import java.util.ArrayList;

public class Carga {
    int[] energiaContenedores = new int[12];
    int[][] mapaCarga = new int[3][3];

    public void generarEnergia() {
        Random rand = new Random();
        System.out.print("Energía inicial: ");
        for (int i = 0; i < 12; i++) {
            energiaContenedores[i] = rand.nextInt(101) + 50;
            System.out.print(energiaContenedores[i] + " ");
        }
        System.out.println();
    }

    public int[] filtrarMultiploDe10() {
        ArrayList<Integer> filtrados = new ArrayList<>();
        for (int val : energiaContenedores) {
            if (val % 10 == 0) filtrados.add(val);
        }

        int[] resultado = new int[filtrados.size()];
        for (int i = 0; i < filtrados.size(); i++) resultado[i] = filtrados.get(i);

        System.out.print("Energía filtrada (múltiplos de 10): ");
        for (int val : resultado) System.out.print(val + " ");
        System.out.println();
        return resultado;
    }

    public void organizarEnBahias(int[] energiaFiltrada) {
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (index < energiaFiltrada.length) {
                    mapaCarga[i][j] = energiaFiltrada[index++];
                } else {
                    mapaCarga[i][j] = -1;
                }
            }
        }

        System.out.println("Mapa de carga:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(mapaCarga[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
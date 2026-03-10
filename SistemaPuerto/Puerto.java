package SistemaPuerto;

import java.util.*;

public class Puerto {

    private Buque[] buques = new Buque[10];
    private Contenedor[][] matriz = new Contenedor[10][10];
    private int contadorCodigo = 1; // Para generar códigos automáticos

    public boolean registrarBuque(Buque buque) {
        for (int i = 0; i < buques.length; i++) {
            if (buques[i] == null) {
                buques[i] = buque;
                System.out.println("Buque registrado en la posición " + i);
                return true;
            }
        }
        System.out.println("No hay espacio para más buques.");
        return false;
    }

    public Buque buscarBuquePorNombre(String nombre) {
        for (Buque b : buques) {
            if (b != null && b.getNombre().equalsIgnoreCase(nombre)) {
                return b;
            }
        }
        return null;
    }

    public boolean registrarContenedor(double peso, String tipo, Buque buque) {
        String codigo = String.format("C%03d", contadorCodigo++);
        Contenedor c = new Contenedor(codigo, peso, tipo);

        for (int fila = 9; fila >= 0; fila--) {
            for (int col = 0; col < 10; col++) {
                if (matriz[fila][col] == null) {
                    matriz[fila][col] = c;
                    buque.agregarContenedor(c);
                    System.out.println("Contenedor " + codigo + " asignado a [" + fila + "][" + col + "]");
                    return true;
                }
            }
        }

        System.out.println("No hay espacio en la matriz para más contenedores.");
        return false;
    }

    public void mostrarMatriz() {
        System.out.println("\n--- Estado del puerto (códigos) ---");
        for (int fila = 0; fila < 10; fila++) {
            for (int col = 0; col < 10; col++) {
                if (matriz[fila][col] != null) {
                    System.out.print(matriz[fila][col].getCodigo() + "\t");
                } else {
                    System.out.print("[ ]\t");
                }
            }
            System.out.println();
        }
    }

    public double pesoTotal() {
        double total = 0;
        for (int fila = 0; fila < 10; fila++) {
            for (int col = 0; col < 10; col++) {
                if (matriz[fila][col] != null) {
                    total += matriz[fila][col].getPeso();
                }
            }
        }
        return total;
    }

    public void listarPorTipo() {
        Map<String, List<Contenedor>> grupos = new HashMap<>();
        for (int fila = 0; fila < 10; fila++) {
            for (int col = 0; col < 10; col++) {
                Contenedor c = matriz[fila][col];
                if (c != null) {
                    grupos.computeIfAbsent(c.getTipo(), k -> new ArrayList<>()).add(c);
                }
            }
        }

        System.out.println("\n--- Contenedores por tipo ---");
        for (String tipo : grupos.keySet()) {
            System.out.println("Tipo: " + tipo);
            for (Contenedor c : grupos.get(tipo)) {
                System.out.println("   " + c);
            }
        }
    }

    public void mostrarBuques() {
        System.out.println("\n--- Buques registrados ---");
        for (int i = 0; i < buques.length; i++) {
            if (buques[i] != null) {
                System.out.println("Posición " + i + ": " + buques[i].getNombre() + " | Contenedores: " + buques[i].cantidadContenedores());
            }
        }
    }
}
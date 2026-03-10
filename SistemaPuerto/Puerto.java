package SistemaPuerto;

import java.util.*;

public class Puerto {

    private Buque[] buques = new Buque[10];
    private Contenedor[][] matriz = new Contenedor[10][10];
    private int contadorCodigo = 1;

    private String[] tiposCarga = {
        "Alimentos",
        "Electrónica",
        "Ropa",
        "Vehículos",
        "Medicamentos",
        "Maquinaria",
        "Químicos",
        "Herramientas"
    };

    Random random = new Random();

    public boolean registrarBuque(Buque buque) {

        for (int i = 0; i < buques.length; i++) {

            if (buques[i] == null) {

                buques[i] = buque;

                System.out.println("Buque registrado: " + buque.getNombre());

                return true;
            }
        }

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

                    return true;
                }
            }
        }

        return false;
    }

    public void mostrarMatriz() {

        System.out.println("\nESTADO DEL PUERTO");

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

        for (String tipo : grupos.keySet()) {

            System.out.println("\nTipo: " + tipo);

            for (Contenedor c : grupos.get(tipo)) {

                System.out.println(c);

            }
        }
    }

    public void mostrarBuques() {

        System.out.println("\nBUQUES REGISTRADOS");

        for (Buque b : buques) {

            if (b != null) {

                System.out.println(
                    b.getNombre() +
                    " | Contenedores: " +
                    b.cantidadContenedores()
                );
            }
        }
    }

    // ⭐ GENERACIÓN AUTOMÁTICA DEL PUERTO
    public void generarPuertoAutomatico() {

        String[] nombresBuques = {
            "Poseidon",
            "Titanic",
            "Atlantic",
            "Neptune",
            "Pacific",
            "Mercury"
        };

        for (String nombre : nombresBuques) {

            Buque b = new Buque(nombre);

            registrarBuque(b);

            int cantidadContenedores = random.nextInt(8) + 3;

            for (int i = 0; i < cantidadContenedores; i++) {

                double peso = 500 + random.nextInt(2500);

                String tipo = tiposCarga[random.nextInt(tiposCarga.length)];

                registrarContenedor(peso, tipo, b);
            }
        }
    }
}
package SistemaPuerto;

import java.util.Random;

public class Puerto {

    private Buque[] buques = new Buque[10];
    private Contenedor[][] matriz = new Contenedor[10][10];
    private int contadorCodigo = 1;

    Random random = new Random();

    String[] tipos = {
        "Alimentos",
        "Electrodomesticos",
        "Ropa",
        "Vehiculos",
        "Medicinas"
    };

    public void generarPuertoAutomatico() {

        String[] nombres = {
            "Titanic",
            "Poseidon",
            "Atlantic",
            "Pacific",
            "Neptune"
        };

        for (int i = 0; i < nombres.length; i++) {

            Buque b = new Buque(nombres[i]);
            buques[i] = b;

            int cantidad = random.nextInt(5) + 3;

            for (int j = 0; j < cantidad; j++) {

                double peso = 500 + random.nextInt(2000);
                String tipo = tipos[random.nextInt(tipos.length)];

                registrarContenedor(peso, tipo, b);
            }
        }
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

    public void mostrarBuques() {

        System.out.println("\nBUQUES");

        for (Buque b : buques) {
            if (b != null) {
                System.out.println(b.getNombre() +
                        " | Contenedores: " +
                        b.cantidadContenedores());
            }
        }
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

    public void totalContenedores() {

        int total = 0;

        for (int fila = 0; fila < 10; fila++) {
            for (int col = 0; col < 10; col++) {

                if (matriz[fila][col] != null) {
                    total++;
                }
            }
        }

        System.out.println("Total de contenedores: " + total);
    }

    public void mostrarContenedores() {

        System.out.println("\nLISTA DE CONTENEDORES");

        for (int fila = 0; fila < 10; fila++) {
            for (int col = 0; col < 10; col++) {

                if (matriz[fila][col] != null) {
                    System.out.println(matriz[fila][col]);
                }
            }
        }
    }
}
package SistemaPuerto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Puerto puerto = new Puerto();

        // Generar datos automáticos
        puerto.generarPuertoAutomatico();

        int opcion;

        do {

            System.out.println("\n===== SISTEMA DE PUERTO =====");
            System.out.println("1. Registrar Buque");
            System.out.println("2. Registrar Contenedores");
            System.out.println("3. Mostrar peso total");
            System.out.println("4. Listar contenedores por tipo");
            System.out.println("5. Mostrar estado del puerto");
            System.out.println("6. Mostrar buques");
            System.out.println("0. Salir");

            System.out.print("Seleccione: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Nombre del buque: ");
                    String nombre = sc.nextLine();

                    puerto.registrarBuque(new Buque(nombre));

                    break;

                case 2:

                    System.out.print("Nombre del buque: ");
                    String nombreBuscado = sc.nextLine();

                    Buque b = puerto.buscarBuquePorNombre(nombreBuscado);

                    if (b == null) {

                        System.out.println("Buque no encontrado");

                        break;
                    }

                    System.out.print("Cantidad de contenedores: ");

                    int cant = sc.nextInt();

                    sc.nextLine();

                    for (int i = 0; i < cant; i++) {

                        System.out.print("Peso: ");

                        double peso = sc.nextDouble();

                        sc.nextLine();

                        System.out.print("Tipo: ");

                        String tipo = sc.nextLine();

                        puerto.registrarContenedor(peso, tipo, b);
                    }

                    break;

                case 3:

                    System.out.println("Peso total: " + puerto.pesoTotal());

                    break;

                case 4:

                    puerto.listarPorTipo();

                    break;

                case 5:

                    puerto.mostrarMatriz();

                    break;

                case 6:

                    puerto.mostrarBuques();

                    break;

            }

        } while (opcion != 0);

        sc.close();
    }
}
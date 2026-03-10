package SistemaPuerto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Puerto puerto = new Puerto();
        int opcion;

        do {
            System.out.println("\n=== SISTEMA DE PUERTO ===");
            System.out.println("1. Registrar Buque");
            System.out.println("2. Registrar Contenedores de un Buque");
            System.out.println("3. Mostrar peso total de contenedores");
            System.out.println("4. Listar contenedores por tipo");
            System.out.println("5. Mostrar estado del puerto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del buque: ");
                    String nombre = sc.nextLine();
                    Buque buque = new Buque(nombre);
                    puerto.registrarBuque(buque);
                    break;

                case 2:
                    System.out.print("Nombre del buque: ");
                    String nombreBuscado = sc.nextLine();
                    Buque buqueEncontrado = puerto.buscarBuquePorNombre(nombreBuscado);

                    if (buqueEncontrado == null) {
                        System.out.println("Buque no encontrado.");
                        break;
                    }

                    System.out.print("Cuántos contenedores registrar: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < cantidad; i++) {
                        System.out.println("Contenedor " + (i + 1));
                        System.out.print("Peso: ");
                        double peso = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Tipo: ");
                        String tipo = sc.nextLine();

                        puerto.registrarContenedor(peso, tipo, buqueEncontrado);
                    }
                    break;

                case 3:
                    System.out.println("Peso total de contenedores: " + puerto.pesoTotal() + " kg");
                    break;

                case 4:
                    puerto.listarPorTipo();
                    break;

                case 5:
                    puerto.mostrarMatriz();
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
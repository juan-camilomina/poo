package SistemaPuerto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Puerto puerto = new Puerto();

        puerto.generarPuertoAutomatico();

        int opcion;

        do {

            System.out.println("\nSISTEMA DE PUERTO");
            System.out.println("1. Mostrar buques");
            System.out.println("2. Mostrar estado del puerto");
            System.out.println("3. Mostrar peso total");
            System.out.println("4. Mostrar contenedores");
            System.out.println("5. Mostrar total de contenedores");
            System.out.println("0. Salir");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    puerto.mostrarBuques();
                    break;

                case 2:
                    puerto.mostrarMatriz();
                    break;

                case 3:
                    System.out.println("Peso total: " + puerto.pesoTotal());
                    break;

                case 4:
                    puerto.mostrarContenedores();
                    break;

                case 5:
                    puerto.totalContenedores();
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}
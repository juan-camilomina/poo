import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Puerto puerto = new Puerto();
        int opcion;

        do {
            System.out.println("\n=== SISTEMA DE PUERTO ===");
            System.out.println("1. Registrar Buque");
            System.out.println("2. Atender Buque");
            System.out.println("3. Mostrar Contenedores");
            System.out.println("4. Buscar Contenedor");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre del buque: ");
                    String nombre = sc.nextLine();
                    Buque buque = new Buque(nombre);

                    System.out.print("Cuantos contenedores trae: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < cantidad; i++) {
                        System.out.println("Contenedor " + (i + 1));
                        System.out.print("Codigo: ");
                        String codigo = sc.nextLine();
                        System.out.print("Peso: ");
                        double peso = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Tipo: ");
                        String tipo = sc.nextLine();

                        Contenedor c = new Contenedor(codigo, peso, tipo);
                        buque.agregarContenedor(c);
                    }

                    puerto.llegadaBuque(buque);
                    break;

                case 2:
                    puerto.atenderBuque();
                    break;

                case 3:
                    puerto.mostrarContenedores();
                    break;

                case 4:
                    System.out.print("Ingrese codigo del contenedor: ");
                    String codigoBuscar = sc.nextLine();
                    puerto.buscarContenedor(codigoBuscar);
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
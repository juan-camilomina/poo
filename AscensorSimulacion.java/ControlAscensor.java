import java.util.Scanner;

public class ControlAscensor {
    private Ascensor ascensor;
    private Piso[] pisos;
    private Scanner sc;

    public ControlAscensor() {
        int MAX_PISOS = 10;
        ascensor = new Ascensor(MAX_PISOS);
        sc = new Scanner(System.in);

        pisos = new Piso[MAX_PISOS + 1];
        for (int i = 1; i <= MAX_PISOS; i++) pisos[i] = new Piso(i, MAX_PISOS);
    }

    public void iniciar() {
        int opcion;
        do {
            System.out.println("\n=== SIMULADOR DE ASCENSOR ===");
            System.out.println("Piso actual: " + ascensor.getPisoActual());
            System.out.println("1. Llamar ascensor a un piso");
            System.out.println("2. Elegir piso destino dentro del ascensor");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: llamarAscensor(); break;
                case 2: elegirDestino(); break;
                case 3: System.out.println("Cerrando simulación..."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }

    private void llamarAscensor() {
        System.out.print("Llamar ascensor al piso: ");
        int piso = sc.nextInt();
        ascensor.agregarPeticion(piso);
        ascensor.moverListaPeticiones();
    }

    private void elegirDestino() {
        System.out.print("Destino dentro del ascensor: ");
        int piso = sc.nextInt();
        ascensor.agregarPeticion(piso);
        ascensor.moverListaPeticiones();
    }
}


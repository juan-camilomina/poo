import java.util.ArrayList;
import java.util.List;

public class Ascensor {
    private int pisoActual;
    private final int MAX_PISOS;
    private String direccion;
    private List<Integer> listaPeticiones;
    private Boton[] botones;
    private Puertas puertas; // Atributo de las puertas

    public Ascensor(int maxPisos) {
        this.pisoActual = 1;
        this.MAX_PISOS = maxPisos;
        this.direccion = "detenido";
        listaPeticiones = new ArrayList<>();

        // Inicialización de botones
        botones = new Boton[MAX_PISOS + 1];
        for (int i = 1; i <= MAX_PISOS; i++) {
            botones[i] = new Boton(i);
        }

        // Inicialización de las puertas
        puertas = new Puertas();
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public void moverA(int objetivo) {
        if (objetivo < 1 || objetivo > MAX_PISOS) {
            System.out.println("Piso inválido.");
            return;
        }

        botones[objetivo].presionar();

        // Cerrar puertas antes de moverse
        puertas.cerrar();

        System.out.println("\nMoviendo ascensor...");

        while (pisoActual != objetivo) {
            if (pisoActual < objetivo) direccion = "subiendo";
            else direccion = "bajando";

            if (pisoActual < objetivo) pisoActual++;
            else pisoActual--;

            System.out.println("Ascensor en piso: " + pisoActual + " (" + direccion + ")");

            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }

        botones[objetivo].apagar();
        direccion = "detenido";

        // Abrir puertas al llegar
        puertas.abrir();

        System.out.println("💡Ascensor llegó al piso " + pisoActual);
    }

    public void agregarPeticion(int piso) {
        if (!listaPeticiones.contains(piso)) listaPeticiones.add(piso);
    }

    public void moverListaPeticiones() {
        while (!listaPeticiones.isEmpty()) {
            int objetivo = listaPeticiones.get(0);
            moverA(objetivo);
            listaPeticiones.remove(0);
        }
    }
}

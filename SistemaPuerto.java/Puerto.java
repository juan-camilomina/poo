import java.util.*;

public class Puerto {

    private Queue<Buque> colaBuques = new LinkedList<>();
    private Stack<Contenedor> pilaContenedores = new Stack<>();
    private HashMap<String, Contenedor> mapaContenedores = new HashMap<>();

    public void llegadaBuque(Buque buque) {
        colaBuques.add(buque);
        System.out.println("Buque agregado a la cola.");
    }

    public void atenderBuque() {
        if (colaBuques.isEmpty()) {
            System.out.println("No hay buques en espera.");
            return;
        }

        Buque buque = colaBuques.poll();
        System.out.println("Atendiendo buque: " + buque.getNombre());

        for (Contenedor c : buque.getContenedores()) {
            pilaContenedores.push(c);
            mapaContenedores.put(c.getCodigo(), c);
        }

        System.out.println("Contenedores descargados.");
    }

    public void mostrarContenedores() {
        if (pilaContenedores.isEmpty()) {
            System.out.println("No hay contenedores en el puerto.");
            return;
        }

        for (Contenedor c : pilaContenedores) {
            System.out.println(c);
        }
    }

    public void buscarContenedor(String codigo) {
        Contenedor c = mapaContenedores.get(codigo);
        if (c != null) {
            System.out.println("Contenedor encontrado:");
            System.out.println(c);
        } else {
            System.out.println("Contenedor no encontrado.");
        }
    }
}
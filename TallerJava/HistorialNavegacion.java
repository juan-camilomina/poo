package TallerJava;

import java.util.LinkedList;

public class HistorialNavegacion {

    private LinkedList<String> historial = new LinkedList<>();

    public void agregarPagina(String url) {
        historial.add(url);
    }

    public void mostrarPaginaActual() {
        if (!historial.isEmpty()) {
            System.out.println("Página actual: " + historial.getLast());
        }
    }

    public void atras() {
        if (!historial.isEmpty()) {
            historial.removeLast();
            System.out.println("Retrocediste");                                         
        }

        if (!historial.isEmpty()) {
            System.out.println("Nueva página actual: " + historial.getLast());
        } else {
            System.out.println("Historial vacío");       
        }
    }

    public void mostrarHistorial() {
        for (String url : historial) {
            System.out.println(url);
        }
    }
}
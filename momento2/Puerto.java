import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Puerto {

    Contenedor[] manifiesto;
    Contenedor[][] patio;
    Queue<Contenedor> inspeccion;
    Stack<Contenedor> buque;

    public Puerto(int n, int r, int k) {
        manifiesto = new Contenedor[n];
        patio = new Contenedor[r][k];
        inspeccion = new LinkedList<>();
        buque = new Stack<>();
    }

    // ARREGLO
    public double registrarContenedores() {
        double total = 0;

        for (int i = 0; i < manifiesto.length; i++) {
            manifiesto[i] = new Contenedor(
                    "C" + i,
                    10 + i,
                    i % 5
            );

            total += manifiesto[i].peso;
        }

        return total;
    }

    // MATRIZ
    public boolean ubicarContenedor(Contenedor c) {

        for (int i = 0; i < patio.length; i++) {
            for (int j = 0; j < patio[i].length; j++) {

                if (patio[i][j] == null) {
                    patio[i][j] = c;
                    return true;
                }
            }
        }

        System.out.println("🚨 Puerto Saturado");
        return false;
    }

    // COLA
    public void enviarInspeccion(Contenedor c) {
        inspeccion.add(c);
    }

    public Contenedor procesarInspeccion() {
        return inspeccion.poll();
    }

    // PILA
    public boolean cargarBuque(Contenedor c) {

        if (!buque.isEmpty()) {
            if (c.peso > buque.peek().peso) {
                System.out.println("❌ Rechazado por inestabilidad");
                return false;
            }
        }

        buque.push(c);
        return true;
    }

    // ELIMINAR DAÑADO
    public void eliminarDañado(String id) {

        Stack<Contenedor> aux = new Stack<>();
        boolean encontrado = false;

        while (!buque.isEmpty()) {

            Contenedor c = buque.pop();

            if (c.id.equals(id)) {
                encontrado = true;
                break;
            }

            aux.push(c);
        }

        while (!aux.isEmpty()) {
            buque.push(aux.pop());
        }

        if (encontrado) {
            System.out.println("🛠 Eliminado: " + id);
        } else {
            System.out.println("No encontrado");
        }
    }

    public void mostrarBuque() {
        System.out.println(buque);
    }
}
public class Main {

    public static void main(String[] args) {

        Puerto puerto = new Puerto(5, 3, 3);

        // registrar
        double total = puerto.registrarContenedores();
        System.out.println("📦 Peso total: " + total);

        // patio
        for (Contenedor c : puerto.manifiesto) {
            puerto.ubicarContenedor(c);
        }

        // inspección
        puerto.enviarInspeccion(puerto.manifiesto[0]);
        System.out.println("🧪 Inspección: " + puerto.procesarInspeccion());

        // buque
        for (Contenedor c : puerto.manifiesto) {
            puerto.cargarBuque(c);
        }

        puerto.mostrarBuque();

        // eliminar ejemplo
        puerto.eliminarDañado("C2");
    }
}
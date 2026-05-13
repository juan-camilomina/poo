package TallerJava;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== HISTORIAL ===");

        HistorialNavegacion h = new HistorialNavegacion();

        h.agregarPagina("google.com");
        h.agregarPagina("github.com");
        h.agregarPagina("stackoverflow.com");

        h.mostrarPaginaActual();   // stackoverflow

        h.atras();                 // vuelve a github

        h.mostrarHistorial();      // muestra lo que queda

        System.out.println("\n=== PRODUCTOS ===");
        DirectorioProductos.ejecutar();

        System.out.println("\n=== PEDIDOS ===");
        SistemaPedidos.ejecutar();
    }
}
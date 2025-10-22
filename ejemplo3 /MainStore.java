import java.util.Scanner;

public class MainStore {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // PARTE 1: Información de la tienda
        StoreInfo store = new StoreInfo(
                "SuperTech Market",
                "Ana Rodríguez",
                "contacto@supertech.com",
                "Tienda especializada en tecnología, videojuegos y accesorios."
        );

        store.showInfo();

        // PARTE 2: Gestión de productos
        ProductManager manager = new ProductManager();
        manager.loadProducts();

        boolean running = true;
        while (running) {
            System.out.println("\n======= MENÚ DE TIENDA =======");
            System.out.println("1. Ver todos los productos");
            System.out.println("2. Agregar nuevo producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Guardar cambios");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int option;
            try {
                option = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Opción inválida. Intente de nuevo.");
                continue;
            }

            switch (option) {
                case 1 -> manager.listProducts();
                case 2 -> manager.addProduct(input);
                case 3 -> manager.deleteProduct(input);
                case 4 -> manager.saveProducts();
                case 5 -> {
                    System.out.println("👋 Saliendo de la tienda. ¡Gracias por visitarnos!");
                    running = false;
                }
                default -> System.out.println("⚠️ Opción no válida.");
            }
        }

        input.close();
    }
}
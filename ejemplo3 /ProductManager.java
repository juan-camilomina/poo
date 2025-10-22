import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {

    private static final String FILE_NAME = "productos.txt";
    private List<String> products = new ArrayList<>();

    // Cargar productos desde el archivo
    public void loadProducts() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("ℹ️ No se encontró el archivo de productos. Se creará uno nuevo al guardar.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) products.add(line);
            }
            System.out.println("✅ Productos cargados desde " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("❌ Error al cargar los productos: " + e.getMessage());
        }
    }

    // Guardar productos en el archivo
    public void saveProducts() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (String p : products) writer.println(p);
            System.out.println("💾 Productos guardados correctamente en " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("❌ Error al guardar los productos: " + e.getMessage());
        }
    }

    // Agregar producto
    public void addProduct(Scanner input) {
        System.out.print("Ingrese el nombre del producto: ");
        String name = input.nextLine();
        System.out.print("Ingrese el precio: ");
        String price = input.nextLine();
        System.out.print("Ingrese una breve descripción: ");
        String desc = input.nextLine();

        products.add(name + " - $" + price + " - " + desc);
        System.out.println("✅ Producto agregado correctamente.");
    }

    // Listar productos
    public void listProducts() {
        System.out.println("\n🧾 Lista de Productos:");
        if (products.isEmpty()) {
            System.out.println(" (No hay productos registrados)");
        } else {
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i));
            }
        }
    }

    // Eliminar producto
    public void deleteProduct(Scanner input) {
        if (products.isEmpty()) {
            System.out.println("⚠️ No hay productos para eliminar.");
            return;
        }

        listProducts();
        System.out.print("Ingrese el número del producto a eliminar: ");
        try {
            int index = Integer.parseInt(input.nextLine());
            if (index < 1 || index > products.size()) {
                System.out.println("⚠️ Número fuera de rango.");
            } else {
                String removed = products.remove(index - 1);
                System.out.println("🗑️ Producto eliminado: " + removed);
            }
        } catch (NumberFormatException e) {
            System.out.println("⚠️ Entrada no válida.");
        }
    }
}

package TallerJava;

import java.util.HashMap;
import java.util.Map;

public class DirectorioProductos {

    public static void ejecutar() {

        Map<Integer, String> productos = new HashMap<>();

        productos.put(101, "Laptop");
        productos.put(102, "Mouse");
        productos.put(103, "Teclado");

        System.out.println("¿Existe 102? " + productos.containsKey(102));

        productos.put(101, "Tablet");

        for (Integer k : productos.keySet()) {
            System.out.println(k + " -> " + productos.get(k));
        }
    }
}
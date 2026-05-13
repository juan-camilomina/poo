package TallerJava;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SistemaPedidos {

    public static void ejecutar() {

        Map<String, LinkedList<String>> pedidos = new HashMap<>();

        LinkedList<String> ana = new LinkedList<>();
        ana.add("Camisa");
        ana.add("Pantalón");
        pedidos.put("Ana", ana);

        LinkedList<String> luis = new LinkedList<>();        
        luis.add("Zapatos");
        pedidos.put("Luis", luis);

        System.out.println("Ana tiene: " + pedidos.get("Ana").size());

        pedidos.get("Luis").add("Gorra");

        for (String c : pedidos.keySet()) {
            System.out.println(c + " -> " + pedidos.get(c));
        }
    }
}
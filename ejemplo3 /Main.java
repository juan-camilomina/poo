import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Electrodomestico> lista = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static final String ARCHIVO = "electrodomesticos.txt";

    // Lista de marcas predefinidas
    private static final String[] MARCAS = {
        "Samsung", "LG", "Bosch", "Mabe", "Whirlpool",
        "Daewoo", "Electrolux", "Panasonic", "Frigidaire", "General Electric"
    };

    public static void main(String[] args) {
        cargarDatos();
        int opcion;

        do {
            System.out.println("\n===== MENÚ DE ELECTRODOMÉSTICOS =====");
            System.out.println("1. Agregar Electrodoméstico");
            System.out.println("2. Agregar Lavadora");
            System.out.println("3. Mostrar todos");
            System.out.println("4. Editar electrodoméstico");
            System.out.println("5. Encender electrodoméstico");
            System.out.println("6. Eliminar electrodoméstico");
            System.out.println("0. Salir y guardar");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> agregarElectrodomestico();
                case 2 -> agregarLavadora();
                case 3 -> mostrarTodos();
                case 4 -> editarElectrodomestico();
                case 5 -> encenderElectrodomestico();
                case 6 -> eliminarElectrodomestico();
                case 0 -> {
                    guardarDatos();
                    System.out.println(" Datos guardados. ¡Hasta luego!");
                }
                default -> System.out.println(" Opción no válida.");
            }
        } while (opcion != 0);
    }

    // --- OPCIONES DEL MENÚ ---

    private static String elegirMarca() {
        System.out.println("\n--- Elige una marca ---");
        for (int i = 0; i < MARCAS.length; i++) {
            System.out.println((i + 1) + ". " + MARCAS[i]);
        }
        System.out.print("Número de marca: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index < 0 || index >= MARCAS.length) {
            System.out.println(" Opción inválida. Se asignará marca 'Genérica'.");
            return "Genérica";
        }
        return MARCAS[index];
    }

    private static void agregarElectrodomestico() {
        String marca = elegirMarca();
        Electrodomestico e = new Electrodomestico(marca);
        lista.add(e);
        System.out.println(" Electrodoméstico agregado: " + marca);
    }

    private static void agregarLavadora() {
        String marca = elegirMarca();
        System.out.print("Capacidad (kg): ");
        int carga = sc.nextInt();
        sc.nextLine();
        Lavadora l = new Lavadora(marca, carga);
        lista.add(l);
        System.out.println(" Lavadora agregada: " + marca + " de " + carga + " kg");
    }

    private static void mostrarTodos() {
        if (lista.isEmpty()) {
            System.out.println(" No hay electrodomésticos registrados.");
            return;
        }
        System.out.println("\n--- Lista de electrodomésticos ---");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i).info());
        }
    }

    private static void editarElectrodomestico() {
        mostrarTodos();
        if (lista.isEmpty()) return;

        System.out.print("Número del electrodoméstico a editar: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index < 0 || index >= lista.size()) {
            System.out.println(" Índice inválido.");
            return;
        }

        Electrodomestico e = lista.get(index);

        System.out.println("Editar marca actual: " + e.getMarca());
        String nuevaMarca = elegirMarca();
        e.setMarca(nuevaMarca);

        System.out.print("Nuevo consumo (actual: " + e.getConsumo() + " W): ");
        e.setConsumo(sc.nextInt());
        sc.nextLine();

        System.out.println(" Electrodoméstico editado correctamente.");
    }

    private static void encenderElectrodomestico() {
        mostrarTodos();
        if (lista.isEmpty()) return;

        System.out.print("Número del electrodoméstico a encender: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index < 0 || index >= lista.size()) {
            System.out.println(" Índice inválido.");
            return;
        }

        lista.get(index).encender();
        System.out.println(" Electrodoméstico encendido.");
    }

    private static void eliminarElectrodomestico() {
        mostrarTodos();
        if (lista.isEmpty()) return;

        System.out.print("Número del electrodoméstico a eliminar: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index < 0 || index >= lista.size()) {
            System.out.println(" Índice inválido.");
            return;
        }

        lista.remove(index);
        System.out.println(" Electrodoméstico eliminado.");
    }

    // --- GUARDAR Y CARGAR DATOS ---

    private static void guardarDatos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Electrodomestico e : lista) {
                if (e instanceof Lavadora l) {
                    bw.write("Lavadora;" + l.getMarca() + ";" + l.getConsumo() + ";" + l.getCarga());
                } else {
                    bw.write("Electrodomestico;" + e.getMarca() + ";" + e.getConsumo());
                }
                bw.newLine();
            }
        } catch (IOException ex) {
            System.out.println(" Error al guardar los datos: " + ex.getMessage());
        }
    }

    private static void cargarDatos() {
        File file = new File(ARCHIVO);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes[0].equals("Lavadora")) {
                    Lavadora l = new Lavadora(partes[1], Integer.parseInt(partes[3]));
                    l.setConsumo(Integer.parseInt(partes[2]));
                    lista.add(l);
                } else {
                    Electrodomestico e = new Electrodomestico(partes[1]);
                    e.setConsumo(Integer.parseInt(partes[2]));
                    lista.add(e);
                }
            }
            System.out.println(" Datos cargados desde archivo.");
        } catch (IOException ex) {
            System.out.println(" Error al cargar los datos: " + ex.getMessage());
        }
    }
}

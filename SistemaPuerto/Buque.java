package SistemaPuerto;

import java.util.ArrayList;
import java.util.List;

public class Buque {

    private String nombre;
    private List<Contenedor> contenedores;

    public Buque(String nombre) {
        this.nombre = nombre;
        this.contenedores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarContenedor(Contenedor c) {
        contenedores.add(c);
    }

    public int cantidadContenedores() {
        return contenedores.size();
    }
}
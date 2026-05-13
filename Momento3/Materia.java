package Momento3;

/*
===========================================
CLASE MATERIA
===========================================
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;

public class Materia {

    private String codigo;
    private String nombre;
    private int cupos;

    // LISTA ENLAZADA
    private LinkedList<String> prerequisitos;

    // COLA
    private Queue<Estudiante> colaEspera;

    public Materia(String codigo,
                   String nombre,
                   int cupos,
                   int creditos) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.cupos = cupos;

        prerequisitos = new LinkedList<>();

        colaEspera = new ArrayDeque<>();
    }

    public void agregarPreRequisito(
            String materia) {

        prerequisitos.add(materia);
    }

    public void inscribir(
            Estudiante estudiante) {

        if(cupos > 0) {

            cupos--;

            System.out.println(
                    estudiante.getNombre()
                    + " inscrito"
            );

        } else {

            colaEspera.offer(estudiante);

            System.out.println(
                    "Materia llena"
            );
        }
    }

    public Queue<Estudiante> getColaEspera() {
        return colaEspera;
    }
}
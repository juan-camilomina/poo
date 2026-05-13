
package Momento3;

import java.util.HashMap;

public class EstudianteService {

    // HASHMAP
    private HashMap<String,
            Estudiante> estudiantes;

    public EstudianteService() {

        estudiantes = new HashMap<>();
    }

    public void registrar(
            Estudiante estudiante) {

        estudiantes.put(
                estudiante.getId(),
                estudiante
        );
    }

    public Estudiante buscar(String id) {

        return estudiantes.get(id);
    }

    public void listar() {

        for(Estudiante e :
                estudiantes.values()) {

            e.mostrarInformacion();

            System.out.println(
                    "Promedio: "
                    + e.calcularPromedio()
            );
        }
    }
}
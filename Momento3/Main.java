/*
===========================================
CLASE EJECUTORA
MAIN
===========================================
*/

package Momento3;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ======================================
        // SERVICIOS
        // ======================================

        EstudianteService estudianteService =
                new EstudianteService();

        RutaService rutaService =
                new RutaService();

        UndoRedoService undoRedoService =
                new UndoRedoService();

        // ======================================
        // OBJETOS
        // ======================================

        Aula aula101 =
                new Aula("101");

        Materia programacion =
                new Materia(
                        "PROG101",
                        "Programacion",
                        2,
                        4
                );

        int opcion;

        do {

            System.out.println("\n=================================");
            System.out.println(" SISTEMA UNIVERSITARIO ");
            System.out.println("=================================");

            System.out.println("1. Registrar estudiante");
            System.out.println("2. Buscar estudiante");
            System.out.println("3. Listar estudiantes");
            System.out.println("4. Inscribir estudiante");
            System.out.println("5. Reservar aula");
            System.out.println("6. Ver rutas");
            System.out.println("7. Deshacer");
            System.out.println("8. Rehacer");
            System.out.println("9. Salir");

            System.out.print("\nSeleccione opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {

                // ======================================
                // REGISTRAR
                // ======================================

                case 1:

                    System.out.println(
                            "\n--- REGISTRO ---"
                    );

                    System.out.print("ID: ");
                    String id = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Semestre: ");
                    int semestre = sc.nextInt();

                    Estudiante estudiante =
                            new Estudiante(
                                    nombre,
                                    id,
                                    email,
                                    semestre
                            );

                    estudianteService.registrar(
                            estudiante
                    );

                    System.out.println(
                            "Registrado correctamente"
                    );

                    undoRedoService.guardarOperacion(
                            "Registrar estudiante"
                    );

                    break;

                // ======================================
                // BUSCAR
                // ======================================

                case 2:

                    System.out.print(
                            "Ingrese ID: "
                    );

                    String buscarId =
                            sc.nextLine();

                    Estudiante encontrado =
                            estudianteService.buscar(
                                    buscarId
                            );

                    if(encontrado != null) {

                        encontrado.mostrarInformacion();

                    } else {

                        System.out.println(
                                "No encontrado"
                        );
                    }

                    break;

                // ======================================
                // LISTAR
                // ======================================

                case 3:

                    estudianteService.listar();

                    break;

                // ======================================
                // INSCRIBIR
                // ======================================

                case 4:

                    System.out.print(
                            "ID estudiante: "
                    );

                    String idInscripcion =
                            sc.nextLine();

                    Estudiante e =
                            estudianteService.buscar(
                                    idInscripcion
                            );

                    if(e != null) {

                        programacion.inscribir(e);

                        undoRedoService.guardarOperacion(
                                "Inscripcion"
                        );

                    } else {

                        System.out.println(
                                "No existe"
                        );
                    }

                    break;

                // ======================================
                // RESERVAR AULA
                // ======================================

                case 5:

                    try {

                        System.out.print(
                                "Dia: "
                        );

                        int dia = sc.nextInt();

                        System.out.print(
                                "Hora: "
                        );

                        int hora = sc.nextInt();

                        System.out.print(
                                "Duracion: "
                        );

                        int duracion =
                                sc.nextInt();

                        aula101.reservar(
                                dia,
                                hora,
                                duracion
                        );

                        undoRedoService.guardarOperacion(
                                "Reserva aula"
                        );

                    } catch(Exception ex) {

                        System.out.println(
                                ex.getMessage()
                        );
                    }

                    break;

                // ======================================
                // RUTAS
                // ======================================

                case 6:

                    rutaService.agregarConexion(
                            0,
                            1,
                            100
                    );

                    rutaService.agregarConexion(
                            1,
                            2,
                            150
                    );

                    rutaService.agregarConexion(
                            2,
                            3,
                            200
                    );

                    rutaService.dijkstra(0);

                    break;

                // ======================================
                // DESHACER
                // ======================================

                case 7:

                    undoRedoService.deshacer();

                    break;

                // ======================================
                // REHACER
                // ======================================

                case 8:

                    undoRedoService.rehacer();

                    break;

                // ======================================
                // SALIR
                // ======================================

                case 9:

                    System.out.println(
                            "Saliendo..."
                    );

                    break;

                default:

                    System.out.println(
                            "Opcion invalida"
                    );
            }

        } while(opcion != 9);

        sc.close();
    }
}
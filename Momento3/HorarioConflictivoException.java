package Momento3;

/*
===========================================
EXCEPCION PERSONALIZADA
===========================================
*/

public class HorarioConflictivoException
        extends Exception {

    public HorarioConflictivoException(
            String mensaje) {

        super(mensaje);
    }
}
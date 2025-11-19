public class BotonLlamada extends Boton {

    protected int pisoActual;
    protected String direccion; // SUBIR / BAJAR

    public BotonLlamada(int pisoActual, String direccion) {
        super("Piso " + pisoActual + " " + direccion);
        this.pisoActual = pisoActual;
        this.direccion = direccion;
    }

    @Override
    public void enviarSolicitud(SistemaControl sistema) {
        if (isPresionado()) {
            System.out.println("[Piso " + pisoActual + "] Solicitud de " + direccion + " enviada.");
            sistema.agregarSolicitudLlamada(pisoActual, direccion);
        }
    }

    public String getDireccion() {
        return direccion;
    }
}

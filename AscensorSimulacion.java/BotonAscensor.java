public class BotonAscensor extends Boton {

    private int pisoDestino;

    public BotonAscensor(int pisoDestino) {
        super("Destino " + pisoDestino);
        this.pisoDestino = pisoDestino;
    }

    @Override
    public void enviarSolicitud(SistemaControl sistema) {
        if (isPresionado()) {
            System.out.println("[Ascensor] Solicitud al piso " + pisoDestino + " enviada.");
            sistema.agregarSolicitudDestino(pisoDestino);
        }
    }
}

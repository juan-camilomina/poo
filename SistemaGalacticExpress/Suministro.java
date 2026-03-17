package SistemaGalacticExpress;

public class Suministro {
    private String id;
    private int nivelEnergia;
    private String prioridad;

    public Suministro(String id, int nivelEnergia, String prioridad) {
        this.id = id;
        this.nivelEnergia = nivelEnergia;
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return id + " | Energia: " + nivelEnergia + " | Prioridad: " + prioridad;
    }
}
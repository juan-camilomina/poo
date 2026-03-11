package galactic;

public class Suministro {
    String id;
    int nivelEnergia;
    String prioridad;

    public Suministro(String id, int nivelEnergia) {
        this.id = id;
        this.nivelEnergia = nivelEnergia;
        this.prioridad = (nivelEnergia > 100) ? "ALTA" : "ESTÁNDAR";
    }

    @Override
    public String toString() {
        return "Suministro{id='" + id + "', nivelEnergia=" + nivelEnergia + ", prioridad='" + prioridad + "'}";
    }
}
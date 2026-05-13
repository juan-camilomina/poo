public class Contenedor {

    String id;
    double peso;
    int prioridad;

    public Contenedor(String id, double peso, int prioridad) {
        this.id = id;
        this.peso = peso;
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Contenedor{" +
                "id='" + id + '\'' +
                ", peso=" + peso +
                ", prioridad=" + prioridad +
                '}';
    }
}
public class Lavadora extends Electrodomestico {
    private int carga; // capacidad en kg

    public Lavadora(String marca, int carga) {
        super(marca);
        this.carga = carga;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    @Override
    public void encender() {
        consumo += 150; // la lavadora consume más al encender
    }

    @Override
    public String info() {
        return "Lavadora " + marca + " de " + carga + " kg tiene un consumo de " + consumo + " W";
    }
}

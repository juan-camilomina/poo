public class Electrodomestico {
    protected String marca;
    protected int consumo; // consumo de energía en vatios

    public Electrodomestico(String marca) {
        this.marca = marca;
        this.consumo = 0;
    }

    public void encender() {
        consumo += 50; // al encender aumenta el consumo
    }

    public String getMarca() {
        return marca;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public String info() {
        return "Electrodoméstico " + marca + " tiene un consumo de " + consumo + " W";
    }
}

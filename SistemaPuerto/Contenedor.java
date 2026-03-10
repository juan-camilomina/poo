package SistemaPuerto;

public class Contenedor {

    private String codigo;
    private double peso;
    private String tipo;

    public Contenedor(String codigo, double peso, String tipo) {
        this.codigo = codigo;
        this.peso = peso;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPeso() {
        return peso;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " | Peso: " + peso + " | Tipo: " + tipo;
    }
}
public class Piso {
    private int numero;
    private Boton botonSubir;
    private Boton botonBajar;

    public Piso(int numero, int maxPisos) {
        this.numero = numero;
        if (numero < maxPisos) botonSubir = new Boton(numero);
        if (numero > 1) botonBajar = new Boton(numero);
    }

    public int getNumero() {
        return numero;
    }

    public Boton getBotonSubir() {
        return botonSubir;
    }

    public Boton getBotonBajar() {
        return botonBajar;
    }
}

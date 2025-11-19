public class Boton {
    private int piso;
    private boolean iluminado;

    public Boton(int piso) {
        this.piso = piso;
        this.iluminado = false;
    }

    public void presionar() {
        iluminado = true;
        System.out.println("Botón del piso " + piso + " iluminado.");
    }

    public void apagar() {
        iluminado = false;
        System.out.println("Botón del piso " + piso + " apagado.");
    }

    public boolean isIluminado() {
        return iluminado;
    }

    public int getPiso() {
        return piso;
    }
}

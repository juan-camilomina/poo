package galactic;

public class Main {
    public static void main(String[] args) {
        Carga carga = new Carga();
        carga.generarEnergia();
        int[] filtrada = carga.filtrarMultiploDe10();
        carga.organizarEnBahias(filtrada);

        Suministro[] manifiesto = new Suministro[9];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int energia = carga.mapaCarga[i][j];
                if (energia != -1) {
                    String id = "C-" + i + "-" + j;
                    manifiesto[index] = new Suministro(id, energia);
                } else {
                    manifiesto[index] = null;
                }
                index++;
            }
        }

        System.out.println("Manifiesto de vuelo:");
        for (int i = 0; i < manifiesto.length; i++) {
            System.out.println("Posición " + i + ": " + manifiesto[i]);
        }
    }
}
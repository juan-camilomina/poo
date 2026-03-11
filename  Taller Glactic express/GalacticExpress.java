package galactic;
public class GalacticExpress {
    public static void main(String[] args) {
        Carga carga = new Carga();

        // Paso 1: Generar energía
        carga.generarEnergia();

        // Paso 2: Filtrar múltiplos de 10
        int[] filtrada = carga.filtrarMultiploDe10();

        // Paso 3: Organizar en matriz 3x3
        carga.organizarEnBahias(filtrada);

        // Paso 4: Crear manifiesto de vuelo
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

        // Mostrar manifiesto
        System.out.println("Manifiesto de vuelo:");
        for (int i = 0; i < manifiesto.length; i++) {
            System.out.println("Posición " + i + ": " + manifiesto[i]);
        }
    }
}
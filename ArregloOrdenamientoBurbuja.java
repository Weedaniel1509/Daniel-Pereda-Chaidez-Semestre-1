import java.util.Random;

public class ArregloOrdenamientoBurbuja {
    public static void main(String[] args) {
        int[] arreglo = new int[100];
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            arreglo[i] = random.nextInt(501) + 500;
        }

        System.out.println("Arreglo antes del ordenamiento:");
        for (int i = 0; i < 100; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println("\n");

        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }

        System.out.println("Arreglo después del ordenamiento:");
        for (int i = 0; i < 100; i++) {
            System.out.print(arreglo[i] + " ");
        }
    }
}

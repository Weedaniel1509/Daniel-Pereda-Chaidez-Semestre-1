public class ArregloNumeros {
    public static void main(String[] args) {
        int[] arreglo = new int[100];

        for (int i = 0; i < 100; i++) {
            arreglo[i] = 1000 + i;
        }

        System.out.println("Los valores del arreglo desde el índice 99 al 0 son:");
        for (int i = 99; i >= 0; i--) {
            System.out.println(arreglo[i]);
        }
    }
}

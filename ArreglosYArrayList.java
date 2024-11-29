import java.util.ArrayList;

public class ArreglosYArrayList {
    public static void main(String[] args) {
        int[] array = new int[100];
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }

        for (int i = 101; i <= 200; i++) {
            arrayList.add(i);
        }

        ArrayList<Integer> resultado = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            resultado.add(array[i]);
        }

        resultado.addAll(arrayList);

        System.out.println("Array y ArrayList combinados:");
        for (int numero : resultado) {
            System.out.print(numero + " ");
        }
    }
}

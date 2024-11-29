// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Random;

public class Numeros500a1000 {
   public Numeros500a1000() {
   }

   public static void main(String[] args) {
      int[] arreglo = new int[100];
      Random rand = new Random();

      for(int i = 0; i < arreglo.length; ++i) {
         arreglo[i] = rand.nextInt(501) + 500;
      }

      System.out.println("Arreglo antes del ordenamiento:");
      mostrarArreglo(arreglo);
      burbuja(arreglo);
      System.out.println("\nArreglo despu\u00e9s del ordenamiento:");
      mostrarArreglo(arreglo);
   }

   public static void burbuja(int[] arreglo) {
      int n = arreglo.length;

      for(int i = 0; i < n - 1; ++i) {
         for(int j = 0; j < n - 1 - i; ++j) {
            if (arreglo[j] > arreglo[j + 1]) {
               int temp = arreglo[j];
               arreglo[j] = arreglo[j + 1];
               arreglo[j + 1] = temp;
            }
         }
      }

   }

   public static void mostrarArreglo(int[] arreglo) {
      int[] var4 = arreglo;
      int var3 = arreglo.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         int num = var4[var2];
         System.out.print(num + " ");
      }

      System.out.println();
   }
}

// Source code is decompiled from a .class file using FernFlower decompiler.
public class Burbuja {
    public Burbuja() {
    }
 
    public static void main(String[] args) {
       int[] arreglo = new int[]{4, 8, 5, 1, 5, 6, 10, 12, 11, 100};
       int n = arreglo.length;
 
       int i;
       int j;
       int temp;
       for(i = 0; i < n - 1; ++i) {
          for(j = i + 1; j < n; ++j) {
             if (arreglo[i] > arreglo[j]) {
                temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
             }
          }
       }
 
       System.out.println("Arreglo ordenado:");
       int[] var6 = arreglo;
       temp = arreglo.length;
 
       for(j = 0; j < temp; ++j) {
          i = var6[j];
          System.out.print(i + " ");
       }
 
    }
 }
 
// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.HashSet;
import java.util.Set;

public class OperacionesArreglo {
   public OperacionesArreglo() {
   }

   public static int sumaDeValores(int[] arreglo) {
      int suma = 0;
      int[] var5 = arreglo;
      int var4 = arreglo.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         int valor = var5[var3];
         suma += valor;
      }

      return suma;
   }

   public static int valoresUnicos(Object[] arreglo) {
      Set<Object> conjuntoUnicos = new HashSet();
      Object[] var5 = arreglo;
      int var4 = arreglo.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         Object valor = var5[var3];
         conjuntoUnicos.add(valor);
      }

      return conjuntoUnicos.size();
   }

   public static void main(String[] args) {
      int[] arregloEnteros = new int[]{1, 2, 3, 4, 5, 5, 3};
      Object[] arregloObjetos = new Object[]{"a", "b", "c", "a", "b", "d"};
      int suma = sumaDeValores(arregloEnteros);
      System.out.println("La suma de los valores del arreglo es: " + suma);
      int unicos = valoresUnicos(arregloObjetos);
      System.out.println("La cantidad de valores \u00fanicos en el arreglo es: " + unicos);
   }
}

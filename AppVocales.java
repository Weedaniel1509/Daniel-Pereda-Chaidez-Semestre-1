// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class AppVocales {
   public AppVocales() {
   }

   public static void main(String[] args) {
      int totalVocales = false;

      try {
         int[] contadorVocales = new int[1];
         CompletableFuture[] futuros = (CompletableFuture[])IntStream.rangeClosed(1, 826).mapToObj((id) -> {
            return CompletableFuture.runAsync(() -> {
               try {
                  if (id % 50 == 0) {
                     System.out.println("Procesando personaje con ID: " + id);
                  }

                  Character personaje = ApiUtil.getCharacterById(id);
                  int cuenta = contarVocales(personaje.name.toLowerCase());
                  synchronized(contadorVocales) {
                     contadorVocales[0] += cuenta;
                  }
               } catch (Exception var6) {
                  System.err.println("Error al obtener el personaje con ID " + id + ": " + var6.getMessage());
               }

            });
         }).toArray((var0) -> {
            return new CompletableFuture[var0];
         });
         CompletableFuture.allOf(futuros).join();
         int totalVocales = contadorVocales[0];
         System.out.println("\nCantidad total de vocales en todos los nombres de los personajes: " + totalVocales);
      } catch (Exception var4) {
         System.err.println("Ocurri\u00f3 un error al contar las vocales: " + var4.getMessage());
      }

   }

   private static int contarVocales(String nombre) {
      int cuenta = 0;
      char[] var5;
      int var4 = (var5 = nombre.toCharArray()).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         char c = var5[var3];
         if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            ++cuenta;
         }
      }

      return cuenta;
   }
}

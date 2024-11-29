// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class AppM {
   public AppM() {
   }

   public static void main(String[] args) {
      Throwable var1 = null;
      Object var2 = null;

      try {
         Scanner scanner = new Scanner(System.in);

         try {
            System.out.println("Lista de personajes disponibles (nombres que empiezan con 'M'):");

            try {
               CompletableFuture[] futures = (CompletableFuture[])IntStream.rangeClosed(1, 826).mapToObj((id) -> {
                  return CompletableFuture.runAsync(() -> {
                     try {
                        Character character = ApiUtil.getCharacterById(id);
                        if (character.name.startsWith("M")) {
                           System.out.println("ID: " + character.id + ", Nombre: " + character.name);
                        }
                     } catch (Exception var2) {
                        System.err.println("Error al obtener el personaje con ID " + id + ": " + var2.getMessage());
                     }

                  });
               }).toArray((var0) -> {
                  return new CompletableFuture[var0];
               });
               CompletableFuture.allOf(futures).join();
            } catch (Exception var15) {
               System.err.println("Ocurri\u00f3 un error al obtener la lista de personajes: " + var15.getMessage());
            }

            System.out.print("\nIngrese el ID del personaje a analizar: ");
            if (scanner.hasNextInt()) {
               int numero = scanner.nextInt();

               try {
                  Character character = ApiUtil.getCharacterById(numero);
                  System.out.println("Nombre: " + character.name);
                  System.out.println("Estado: " + character.status);
                  System.out.println("Cantidad de Episodios: " + character.episode.size());
               } catch (Exception var14) {
                  System.err.println("Ocurri\u00f3 un error al obtener el personaje con ID " + numero + ": " + var14.getMessage());
               }
            } else {
               System.err.println("Entrada no v\u00e1lida. Debe ingresar un n\u00famero.");
            }
         } finally {
            if (scanner != null) {
               scanner.close();
            }

         }

      } catch (Throwable var17) {
         if (var1 == null) {
            var1 = var17;
         } else if (var1 != var17) {
            var1.addSuppressed(var17);
         }

         throw var1;
      }
   }
}

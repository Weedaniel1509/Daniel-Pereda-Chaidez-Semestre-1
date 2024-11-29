import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AppVocales {

    public static void main(String[] args) {
        // Usamos AtomicInteger para evitar la necesidad de sincronización explícita
        AtomicInteger contadorVocales = new AtomicInteger(0);

        try {
            // Procesamos los personajes de manera asíncrona
            CompletableFuture<?>[] futuros = IntStream.rangeClosed(1, 826)
                    .mapToObj(id -> CompletableFuture.runAsync(() -> {
                        try {
                            if (id % 50 == 0) {
                                System.out.println("Procesando personaje con ID: " + id);
                            }

                            Character personaje = ApiUtil.getCharacterById(id);
                            // Contamos las vocales en el nombre del personaje
                            int cuenta = contarVocales(personaje.name.toLowerCase());
                            // Sumamos al contador usando AtomicInteger
                            contadorVocales.addAndGet(cuenta);
                        } catch (Exception e) {
                            System.err.println("Error al obtener el personaje con ID " + id + ": " + e.getMessage());
                        }
                    }))
                    .toArray(CompletableFuture[]::new);

            // Esperamos a que todos los futuros se completen
            CompletableFuture.allOf(futuros).join();

            // Mostramos el total de vocales
            System.out.println("\nCantidad total de vocales en todos los nombres de los personajes: " + contadorVocales.get());
        } catch (Exception e) {
            System.err.println("Ocurrió un error al contar las vocales: " + e.getMessage());
        }
    }

    private static int contarVocales(String nombre) {
        int cuenta = 0;
        for (char c : nombre.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cuenta++;
            }
        }
        return cuenta;
    }
}

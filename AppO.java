import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class AppO {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) { // Usamos try-with-resources para el Scanner
            // Imprimir lista de personajes cuyo nombre termina con 'o'
            System.out.println("Lista de personajes disponibles (nombres que terminan con 'o'):");

            // Obtener personajes cuyos nombres terminan con 'o' de manera asíncrona
            try {
                CompletableFuture<?>[] futures = IntStream.rangeClosed(1, 826) // IDs de los personajes
                        .mapToObj(id -> CompletableFuture.runAsync(() -> {
                            try {
                                Character character = ApiUtil.getCharacterById(id);
                                if (character.name.endsWith("o")) {
                                    System.out.println("ID: " + character.id + ", Nombre: " + character.name);
                                }
                            } catch (Exception e) {
                                System.err.println("Error al obtener el personaje con ID " + id + ": " + e.getMessage());
                            }
                        }))
                        .toArray(CompletableFuture[]::new); // Convertimos en array de futures

                CompletableFuture.allOf(futures).join(); // Esperar a que todos los futures se completen
            } catch (Exception e) {
                System.err.println("Ocurrió un error al obtener la lista de personajes: " + e.getMessage());
            }

            // Solicitar un ID de personaje al usuario
            System.out.print("\nIngrese el ID del personaje a analizar: ");
            if (scanner.hasNextInt()) {
                int numero = scanner.nextInt();
                try {
                    Character character = ApiUtil.getCharacterById(numero);
                    System.out.println("Nombre: " + character.name);
                    System.out.println("Estado: " + character.status);
                    System.out.println("Cantidad de Episodios: " + character.episode.size());
                } catch (Exception e) {
                    System.err.println("Ocurrió un error al obtener el personaje con ID " + numero + ": " + e.getMessage());
                }
            } else {
                System.err.println("Entrada no válida. Debe ingresar un número.");
            }
        } catch (Exception e) {
            System.err.println("Error en la ejecución: " + e.getMessage());
        }
    }
}

package com.tienda;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class APIHandler {
    // Método para obtener la cantidad de productos disponibles
    public static int getProductCount() {
        String response = API.fetch("https://fakestoreapi.com/products");
        Gson gson = new Gson();
        Type productListType = new TypeToken<List<Map<String, Object>>>() {}.getType();
        List<Map<String, Object>> products = gson.fromJson(response, productListType);
        return products.size();
    }

    // Método para obtener un producto por su ID
    public static void getProductById(Scanner scanner) {
        int productCount = getProductCount();
        boolean validId = false;
        int productId = 0;

        // Validación del ID
        while (!validId) {
            System.out.print("Ingrese el ID del producto (1-" + productCount + "): ");
            if (scanner.hasNextInt()) {
                productId = scanner.nextInt();
                if (productId >= 1 && productId <= productCount) {
                    validId = true; // ID válido
                } else {
                    System.out.println("Error: El ID debe estar entre 1 y " + productCount);
                }
            } else {
                System.out.println("Error: Por favor ingrese un número válido.");
                scanner.next(); // Limpiar el buffer
            }
        }

        // Aquí puedes hacer la llamada a la API para obtener el producto por ID
        String response = API.fetch("https://fakestoreapi.com/products/" + productId);
        OutputHandler.printFormattedProduct(response);
    }

    public static void getAllProducts() {
        System.out.println("Productos disponibles:");
        String response = API.fetch("https://fakestoreapi.com/products");
        OutputHandler.printFormattedProducts(response);
    }

    

    public static void getSingleProduct(Scanner scanner) {
        System.out.print("Ingrese el ID del producto: ");
        int id = scanner.nextInt();
        String response = API.fetch("https://fakestoreapi.com/products/" + id);
        OutputHandler.printFormattedProduct(response);
    }

// Método para agregar un producto
public static void addProduct(Scanner scanner) {
    // Obtener los datos del nuevo producto
    System.out.println("Ingrese los detalles del nuevo producto:");

    System.out.print("Título: ");
    String title = scanner.nextLine();  // Usar nextLine para capturar entradas con espacios

    // Validación para evitar que el título quede vacío
    while (title.trim().isEmpty()) {
        System.out.print("El título no puede estar vacío. Ingrese nuevamente: ");
        title = scanner.nextLine();
    }

    System.out.print("Precio: ");
    double price = getValidPrice(scanner);

    System.out.print("Descripción: ");
    String description = scanner.nextLine();  // Usar nextLine para capturar entradas con espacios

    // Validación para evitar que la descripción quede vacía
    while (description.trim().isEmpty()) {
        System.out.print("La descripción no puede estar vacía. Ingrese nuevamente: ");
        description = scanner.nextLine();
    }

    System.out.print("Categoría: ");
    String category = scanner.nextLine();  // Usar nextLine para capturar entradas con espacios

    // Validación para evitar que la categoría quede vacía
    while (category.trim().isEmpty()) {
        System.out.print("La categoría no puede estar vacía. Ingrese nuevamente: ");
        category = scanner.nextLine();
    }

    System.out.print("Imagen (URL): ");
    String image = scanner.nextLine();  // Usar nextLine para capturar entradas con espacios

    // Validación para evitar que la URL de la imagen quede vacía
    while (image.trim().isEmpty()) {
        System.out.print("La URL de la imagen no puede estar vacía. Ingrese nuevamente: ");
        image = scanner.nextLine();
    }

    // Solicitar los datos para la calificación
    System.out.print("Valoración (de 1.0 a 5.0): ");
    double ratingRate = getValidRating(scanner);

    System.out.print("Número de valoraciones (existencias): ");
    int ratingCount = getValidRatingCount(scanner);

    // Crear un mapa para representar el nuevo producto
    Map<String, Object> newProduct = new HashMap<>();
    newProduct.put("title", title);
    newProduct.put("price", price);
    newProduct.put("description", description);
    newProduct.put("category", category);
    newProduct.put("image", image);
    
    // Crear un mapa para la calificación
    Map<String, Object> rating = new HashMap<>();
    rating.put("rate", ratingRate);
    rating.put("count", ratingCount);

    // Agregar la calificación al producto
    newProduct.put("rating", rating);
    newProduct.put("isActive", 1);  // Producto activo al agregarlo
    
    // Convertir el mapa a JSON
    Gson gson = new Gson();
    String jsonProduct = gson.toJson(newProduct);
    
    // Realizar la solicitud POST para agregar el producto
    String response = API.post("https://fakestoreapi.com/products", jsonProduct);

    // Ver la respuesta de la API
    System.out.println(response); // Agregar para depuración

    if (response != null && !response.isEmpty()) {
        System.out.println("Producto agregado con éxito.");
    } else {
        System.out.println("Hubo un error al agregar el producto.");
    }
}

// Método para obtener el precio válido
public static double getValidPrice(Scanner scanner) {
    while (true) {
        try {
            double price = scanner.nextDouble();
            if (price > 0) {
                scanner.nextLine();  // Limpiar el buffer después de leer el precio
                return price;
            } else {
                System.out.print("El precio debe ser mayor que 0. Ingrese el precio nuevamente: ");
            }
        } catch (InputMismatchException e) {
            System.out.print("Entrada inválida. Ingrese un número válido para el precio: ");
            scanner.next(); // Limpiar el buffer
        }
    }
}

// Método para obtener una valoración válida (de 1.0 a 5.0)
public static double getValidRating(Scanner scanner) {
    while (true) {
        try {
            double rating = scanner.nextDouble();
            if (rating >= 1.0 && rating <= 5.0) {
                scanner.nextLine();  // Limpiar el buffer después de leer la valoración
                return rating;
            } else {
                System.out.print("La valoración debe estar entre 1.0 y 5.0. Ingrese nuevamente: ");
            }
        } catch (InputMismatchException e) {
            System.out.print("Entrada inválida. Ingrese una valoración válida entre 1.0 y 5.0: ");
            scanner.next(); // Limpiar el buffer
        }
    }
}

// Método para obtener el número de valoraciones (existencias) válido
public static int getValidRatingCount(Scanner scanner) {
    while (true) {
        try {
            int count = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer después de leer el número
            if (count >= 0) {
                return count;
            } else {
                System.out.print("El número de valoraciones debe ser un número positivo. Ingrese nuevamente: ");
            }
        } catch (InputMismatchException e) {
            System.out.print("Entrada inválida. Ingrese un número válido para el número de valoraciones: ");
            scanner.next(); // Limpiar el buffer
        }
    }
}



// Método para eliminar un producto
// Método para eliminar un producto
public static void deleteProduct(Scanner scanner) {
    int productCount = getProductCount();
    boolean validId = false;
    int productId = 0;

    // Validación del ID
    while (!validId) {
        System.out.print("Ingrese el ID del producto a eliminar (1-" + productCount + "): ");
        if (scanner.hasNextInt()) {
            productId = scanner.nextInt();
            if (productId >= 1 && productId <= productCount) {
                validId = true; // ID válido
            } else {
                System.out.println("Error: El ID debe estar entre 1 y " + productCount);
            }
        } else {
            System.out.println("Error: Por favor ingrese un número válido.");
            scanner.next(); // Limpiar el buffer
        }
    }

    // Realizar la solicitud PUT para cambiar el estado del producto
    String url = "https://fakestoreapi.com/products/" + productId;
    String response = API.fetch(url);  // Obtener el producto original

    // Si el producto existe, se puede proceder a marcarlo como inactivo
    if (response != null) {
        // Cambiar el valor de 'isActive' a 0 (desactivado)
        Gson gson = new Gson();
        Map<String, Object> product = gson.fromJson(response, Map.class);
        product.put("isActive", 0);  // Marcar como eliminado (inactivo)

        // Convertir el mapa de vuelta a JSON
        String jsonProduct = gson.toJson(product);

        // Realizar la solicitud PUT para actualizar el producto
        response = API.put(url, jsonProduct);

        if (response != null) {
            System.out.println("Producto marcado como eliminado.");
        } else {
            System.out.println("Hubo un error al eliminar el producto.");
        }
    } else {
        System.out.println("Producto no encontrado.");
    }
}

public static void getActiveProducts() {
    System.out.println("Productos Activos:");
    String response = API.fetch("https://fakestoreapi.com/products");  // Obtener todos los productos
    Gson gson = new Gson();
    Type productListType = new TypeToken<List<Map<String, Object>>>() {}.getType();
    List<Map<String, Object>> products = gson.fromJson(response, productListType);

    // Recorrer los productos y filtrar aquellos que están marcados como eliminados (isActive = 1)
    for (Map<String, Object> product : products) {
        if (product.get("isActive") != null && ((Double) product.get("isActive")).intValue() == 1) {
            // Imprimir los productos eliminados
            System.out.println("==============================================");
            System.out.printf("ID: %s\n", product.get("id"));
            System.out.printf("Título: %s\n", product.get("title"));
            System.out.printf("Precio: $%.2f\n", product.get("price"));
            System.out.printf("Descripción: %s\n", product.get("description"));
            System.out.printf("Categoría: %s\n", product.get("category"));
            System.out.printf("Imagen: %s\n", product.get("image"));
            Map<String, Object> rating = (Map<String, Object>) product.get("rating");
            System.out.printf("Valoración: %.1f (Existencias: %d)\n",
                    rating.get("rate"),
                    ((Double) rating.get("count")).intValue());
        }
    }
    System.out.println("==============================================\n");
}


public static void getDeletedProducts() {
    System.out.println("Productos eliminados:");
    String response = API.fetch("https://fakestoreapi.com/products");  // Obtener todos los productos
    Gson gson = new Gson();
    Type productListType = new TypeToken<List<Map<String, Object>>>() {}.getType();
    List<Map<String, Object>> products = gson.fromJson(response, productListType);

    // Recorrer los productos y filtrar aquellos que están marcados como eliminados (isActive = 0)
    for (Map<String, Object> product : products) {
        if (product.get("isActive") != null && ((Double) product.get("isActive")).intValue() == 0) {
            // Imprimir los productos eliminados
            System.out.println("==============================================");
            System.out.printf("ID: %s\n", product.get("id"));
            System.out.printf("Título: %s\n", product.get("title"));
            System.out.printf("Precio: $%.2f\n", product.get("price"));
            System.out.printf("Descripción: %s\n", product.get("description"));
            System.out.printf("Categoría: %s\n", product.get("category"));
            System.out.printf("Imagen: %s\n", product.get("image"));
            Map<String, Object> rating = (Map<String, Object>) product.get("rating");
            System.out.printf("Valoración: %.1f (Existencias: %d)\n",
                    rating.get("rate"),
                    ((Double) rating.get("count")).intValue());
        }
    }
    System.out.println("==============================================\n");
}



    public static void limitResults(Scanner scanner) {
        System.out.print("Ingrese el número de productos que desea ver: ");
        int limit = scanner.nextInt();
        String response = API.fetch("https://fakestoreapi.com/products?limit=" + limit);
        OutputHandler.printFormattedProducts(response);
    }

    public static void sortResults(Scanner scanner) {
        System.out.println("Opciones de orden:");
        System.out.println("1) Ordenar por precio ascendente");
        System.out.println("2) Ordenar por precio descendente");
        int option = scanner.nextInt();

        String sortMode = option == 1 ? "asc" : option == 2 ? "desc" : "";
        String response = API.fetch("https://fakestoreapi.com/products?sort=" + sortMode);
        OutputHandler.printFormattedProducts(response);
    }

    public static void getCategories() {
        String response = API.fetch("https://fakestoreapi.com/categories");
        OutputHandler.printCategories(response);
    }
}

package com.tienda;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class OutputHandler {
    public static void printFormattedProducts(String jsonResponse) {
        // Parsear el JSON
        Gson gson = new Gson();
        Type productListType = new TypeToken<List<Map<String, Object>>>() {}.getType();
        List<Map<String, Object>> products = gson.fromJson(jsonResponse, productListType);

        // Imprimir cabecera del catálogo
        System.out.println("\n--- Catálogo de Productos ---");
        System.out.println("Productos disponibles:\n");

        // Formatear e imprimir cada producto
        for (Map<String, Object> product : products) {
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
        System.out.println("==============================================\n");
    }

    public static void printFormattedProduct(String jsonResponse) {
        // Parsear el JSON de un solo producto
        Gson gson = new Gson();
        Type productType = new TypeToken<Map<String, Object>>() {}.getType();
        Map<String, Object> product = gson.fromJson(jsonResponse, productType);

        // Imprimir detalles del producto
        System.out.println("\n--- Detalles del Producto ---");
        System.out.println("Producto encontrado:\n");
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
        System.out.println("==============================================\n");
    }

    public static void printCategories(String jsonResponse) {
        // Formatear e imprimir categorías
        System.out.println("Categorías:\n" + jsonResponse);
    }
}

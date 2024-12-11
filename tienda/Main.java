package com.tienda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        // Mostrar cantidad de productos al iniciar
        int productCount = APIHandler.getProductCount();
        System.out.println("Actualmente hay " + productCount + " productos disponibles.");

        do {
            System.out.println("\nBienvenido al catálogo de productos.\n");
            System.out.println("Selecciona una de las siguientes opciones:");
            System.out.println("1) Buscar Producto por ID");
            System.out.println("2) Buscar Todos los Productos");
            System.out.println("3) Agregar Producto");
            System.out.println("4) Eliminar Producto");
            System.out.println("5) Funciones Extras");
            System.out.println("6) Ver Productos Activos");
            System.out.println("7) Ver Productos Eliminados");
            System.out.println("8) Generar PDF del Catálogo");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1 -> APIHandler.getProductById(scanner);
                case 2 -> APIHandler.getAllProducts();
                case 3 -> APIHandler.addProduct(scanner);
                case 4 -> APIHandler.deleteProduct(scanner);
                case 5 -> showExtraMenu(scanner);
                case 6 -> APIHandler.getActiveProducts();
                case 7 -> APIHandler.getDeletedProducts();
                case 8 -> generatePdf(scanner, productCount); // Nueva función con manejo de errores
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida, intenta de nuevo.");
            }
        } while (option != 0);

        scanner.close();
    }

    private static void showExtraMenu(Scanner scanner) {
        int subOption;
        do {
            System.out.println("\nFunciones Extras:");
            System.out.println("1) Obtener un producto específico");
            System.out.println("2) Limitar resultados");
            System.out.println("3) Ordenar resultados");
            System.out.println("4) Obtener categorías");
            System.out.println("0) Regresar al menú principal");
            System.out.print("Opción: ");
            subOption = scanner.nextInt();

            switch (subOption) {
                case 1 -> APIHandler.getSingleProduct(scanner);
                case 2 -> APIHandler.limitResults(scanner);
                case 3 -> APIHandler.sortResults(scanner);
                case 4 -> APIHandler.getCategories();
                case 0 -> System.out.println("Regresando al menú principal...");
                default -> System.out.println("Opción no válida, intenta de nuevo.");
            }
        } while (subOption != 0);
    }

    private static void generatePdf(Scanner scanner, int productCount) {
        int productId;

        do {
            System.out.print("Ingresa el ID del producto para generar el PDF (1-" + productCount + "): ");
            productId = scanner.nextInt();

            if (productId < 1 || productId > productCount) {
                System.out.println("El ID ingresado no es válido. Por favor, ingresa un ID entre 1 y " + productCount + ".");
            } else {
                CrearPDF.crearPdfDeProducto(productId);
                break;
            }
        } while (true);
    }
}

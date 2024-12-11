package com.tienda;

import java.util.Map;

import com.google.gson.Gson;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;


public class CrearPDF {
    public static void crearPdfDeProducto(int productId) {
        try {
            String apiUrl = "https://fakestoreapi.com/products/" + productId; // URL de tu API
            String jsonResponse = API.fetch(apiUrl);

            if (jsonResponse != null && !jsonResponse.isEmpty()) {
                Gson gson = new Gson();
                Map<String, Object> product = gson.fromJson(jsonResponse, Map.class);

                PdfWriter writer = new PdfWriter("producto_" + productId + ".pdf");
                PdfDocument pdf = new PdfDocument(writer);
                Document document = new Document(pdf);

                // Cargar fuente personalizada
                String fontPath = "C:/Users/danie/Downloads/Tipografia.ttf"; // Asegúrate de que esta ruta sea correcta
                PdfFont titleFont = PdfFontFactory.createFont(fontPath, PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);
                PdfFont boldFont = PdfFontFactory.createFont("Helvetica-Bold");
                PdfFont regularFont = PdfFontFactory.createFont("Helvetica");

                // Título del documento centrado
                Paragraph title = new Paragraph("Detalles del Producto")
                        .setFont(titleFont)
                        .setFontSize(20)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setMarginBottom(20)
                        .setFontColor(ColorConstants.BLACK);
                document.add(title);
                      
                // Imagen del producto centrada
                String imagePath = (String) product.get("image");
                try {
                    Image img = new Image(ImageDataFactory.create(imagePath));
                    img.setWidth(200);
                    img.setHeight(200);
                    img.setHorizontalAlignment(HorizontalAlignment.CENTER); // Alinea la imagen al centro
                    document.add(img);
                } catch (Exception e) {
                    System.out.println("No se pudo cargar la imagen desde la URL: " + imagePath);
                }
                
                // Detalles del producto centrado
                document.add(new Paragraph("ID:")
                        .setFont(boldFont)
                        .setFontSize(12)
                        .setTextAlignment(TextAlignment.CENTER));
                document.add(new Paragraph(product.get("id").toString())
                        .setFont(regularFont)
                        .setFontSize(12)
                        .setTextAlignment(TextAlignment.CENTER));

                document.add(new Paragraph("Título:")
                        .setFont(boldFont)
                        .setFontSize(12)
                        .setTextAlignment(TextAlignment.CENTER));
                document.add(new Paragraph(product.get("title").toString())
                        .setFont(regularFont)
                        .setFontSize(12)
                        .setTextAlignment(TextAlignment.CENTER));

                document.add(new Paragraph("Precio:")
                        .setFont(boldFont)
                        .setFontSize(12)
                        .setTextAlignment(TextAlignment.CENTER));
                document.add(new Paragraph("$" + product.get("price").toString())
                        .setFont(regularFont)
                        .setFontSize(12)
                        .setTextAlignment(TextAlignment.CENTER));

                document.add(new Paragraph("Descripción:")
                        .setFont(boldFont)
                        .setFontSize(12)
                        .setTextAlignment(TextAlignment.CENTER));
                document.add(new Paragraph(product.get("description").toString())
                        .setFont(regularFont)
                        .setFontSize(12)
                        .setTextAlignment(TextAlignment.CENTER));

                document.add(new Paragraph("Categoría:")
                        .setFont(boldFont)
                        .setFontSize(12)
                        .setTextAlignment(TextAlignment.CENTER));
                document.add(new Paragraph(product.get("category").toString())
                        .setFont(regularFont)
                        .setFontSize(12)
                        .setTextAlignment(TextAlignment.CENTER));

               

                document.close();
                System.out.println("PDF creado exitosamente para el producto con ID: " + productId);
            } else {
                System.out.println("Error: No se encontraron datos para el producto con ID: " + productId);
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al generar el PDF: " + e.getMessage());
        }
    }
}

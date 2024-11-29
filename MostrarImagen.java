import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MostrarImagen {

    public static void mostrarImagen(String url) {
        try {
            // Crear un objeto URL con la URL de la imagen
            URL imageUrl = new URL(url);

            // Cargar la imagen desde la URL
            Image image = ImageIO.read(imageUrl);

            // Crear un JFrame para mostrar la imagen
            JFrame frame = new JFrame("Imagen desde URL");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Crear un panel para mostrar la imagen
            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // Dibujar la imagen en el panel
                    g.drawImage(image, 0, 0, this);
                }
            };

            // Establecer el tamaño del panel basado en la imagen
            frame.setSize(image.getWidth(null), image.getHeight(null));
            frame.add(panel);
            frame.setVisible(true);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar la imagen: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // URL de la imagen (puede ser cualquier URL válida)
        String url = "https://us-tuna-sounds-images.voicemod.net/416367ec-3751-41b9-8265-3fc598920f48-1699484421469.jpg";
        mostrarImagen(url);
    }
}

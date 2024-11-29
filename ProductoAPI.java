import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;
public class ProductoAPI {

    public static JSONObject obtenerProductoPorId(int id) {
        //Aqui use otra api porque la del platzi ya no sirvio
        String urlString = "https://fakestoreapi.com/products/" + id;
        try {
            URL url = new URL(urlString);
            
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
            JSONObject producto = new JSONObject(response.toString());
            return producto;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        int id = 120; 
        JSONObject producto = obtenerProductoPorId(id);
        
        if (producto != null) {
            System.out.println("Producto encontrado: ");
            System.out.println("ID: " + producto.getInt("id"));
            System.out.println("Título: " + producto.getString("title"));
            System.out.println("Precio: " + producto.getDouble("price"));
            System.out.println("Descripción: " + producto.getString("description"));
            System.out.println("Categoría: " + producto.getString("category"));
            System.out.println("Imagen: " + producto.getString("image"));
            System.out.println("Rating: " + producto.getJSONObject("rating").getDouble("rate"));
            System.out.println("Rating Count: " + producto.getJSONObject("rating").getInt("count"));
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}

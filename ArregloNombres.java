public class ArregloNombres {
    public static void main(String[] args) {
        String[] nombres = new String[5];
        
        nombres[0] = "Fernando Zamudio";
        nombres[1] = "Ximena Reyes";
        nombres[2] = "Luis Velazquez";
        nombres[3] = "Hector Castro";
        nombres[4] = "Eduardo";
        
        System.out.println("Los nombres ingresados son:");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }
}

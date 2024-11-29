public class AppPersona {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        p1.nombre = "Juan";
        p1.edad = 30;

        System.out.println("Nombre: " + p1.nombre + ", Edad: " + p1.edad);

        Persona p2 = new Persona();
        p2.nombre = "Ana";
        p2.edad = 25;

        System.out.println("Nombre: " + p2.nombre + ", Edad: " + p2.edad);
    }
}

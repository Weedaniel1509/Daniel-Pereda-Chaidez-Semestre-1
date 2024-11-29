import java.util.Scanner;

public class SumaYMultiplicacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese un número menor a 100: ");
        int numero = scanner.nextInt();
        
        if (numero >= 100) {
            System.out.println("El número debe ser menor a 100.");
        } else {
            int suma = 0;
            for (int i = 1; i <= numero; i++) {
                suma += i;
            }
            
            int dobleSuma = suma * 2;
            
            System.out.println("El doble de la suma de los números entre 1 y " + numero + " es: " + dobleSuma);
        }
        
        scanner.close();
    }
}

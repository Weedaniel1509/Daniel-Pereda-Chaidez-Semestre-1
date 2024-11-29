import java.util.Scanner;

public class ContarCifras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un numero entero positivo: ");
        int numero = scanner.nextInt();
        
        int cifras = String.valueOf(numero).length();
        
        System.out.println("El numero tiene " + cifras + " cifra(s).");
        scanner.close();
    }
}

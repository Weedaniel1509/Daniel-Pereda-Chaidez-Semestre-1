import java.util.Scanner;

public class MayorNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int mayorNumero = Integer.MIN_VALUE;
        
        for (int i = 1; i <= 5; i++) {
            System.out.print("Introduce el número #" + i + ": ");
            int numero = scanner.nextInt();
  
            if (numero > mayorNumero) {
                mayorNumero = numero;
            }
        }
        
        System.out.println("El número mayor introducido es: " + mayorNumero);
        
        scanner.close();
    }
}

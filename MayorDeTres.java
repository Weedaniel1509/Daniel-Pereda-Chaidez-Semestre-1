import java.util.Scanner;

public class MayorDeTres {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce el primer número: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Introduce el segundo número: ");
        int num2 = scanner.nextInt();
        
        System.out.print("Introduce el tercer número: ");
        int num3 = scanner.nextInt();
        
        int mayor = Math.max(num1, Math.max(num2, num3));//Encontre esta funcion que funciona mejor
        
        System.out.println("El mayor número es: " + mayor);
        scanner.close();
    }
}

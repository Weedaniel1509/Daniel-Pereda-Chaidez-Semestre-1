import java.util.Scanner;

public class ConvertidorDolarPeso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double tasaDeCambio = 19.32;
        System.out.print("Ingrese la cantidad en dólares: ");
        double dolares = scanner.nextDouble();
        double pesos = dolares * tasaDeCambio;
        System.out.println(dolares + " dólares equivalen a " + pesos + " pesos.");
        
        scanner.close();
    }
}

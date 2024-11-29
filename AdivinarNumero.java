import java.util.Scanner;

public class AdivinarNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numeroSecreto = (int) (Math.random() * 100) + 1;
        
        int intento = 0;
        int maxIntentos = 10;
        int numeroUsuario = 0;

        System.out.println("¡Adivina el número entre 1 y 100!");
        
        while (intento < maxIntentos) {
            System.out.print("Intento #" + (intento + 1) + ": Ingrese un número: ");
            numeroUsuario = scanner.nextInt();
            intento++;
            
            if (numeroUsuario < numeroSecreto) {
                System.out.println("¡Muy bajo! Intenta de nuevo.");
            } else if (numeroUsuario > numeroSecreto) {
                System.out.println("¡Muy alto! Intenta de nuevo.");
            } else {
                System.out.println("¡Exacto! Usted adivinó el número en " + intento + " intentos.");
                break;
            }
        }

        if (numeroUsuario != numeroSecreto) {
            System.out.println("Lo siento, no adivinaste el número. El número era: " + numeroSecreto);
        }

        scanner.close();
    }
}

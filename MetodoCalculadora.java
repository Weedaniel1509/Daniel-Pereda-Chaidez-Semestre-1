import java.util.Scanner;

public class MetodoCalculadora {

    public static double sumar(double num1, double num2) {
        return num1 + num2;
    }

    public static double restar(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiplicar(double num1, double num2) {
        return num1 * num2;
    }

    public static double dividir(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Error: No se puede dividir por cero.");
            return Double.NaN;
        }
        return num1 / num2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num1, num2, resultado;
        char operacion;

        System.out.println("Calculadora - Elija una operación:");
        System.out.println("1. Sumar (+)");
        System.out.println("2. Restar (-)");
        System.out.println("3. Multiplicar (*)");
        System.out.println("4. Dividir (/)");

        System.out.print("Ingrese la operación (+, -, *, /): ");
        operacion = sc.next().charAt(0);

        System.out.print("Ingrese el primer número: ");
        num1 = sc.nextDouble();
        System.out.print("Ingrese el segundo número: ");
        num2 = sc.nextDouble();

        switch (operacion) {
            case '+':
                resultado = sumar(num1, num2);
                System.out.println("Resultado: " + resultado);
                break;
            case '-':
                resultado = restar(num1, num2);
                System.out.println("Resultado: " + resultado);
                break;
            case '*':
                resultado = multiplicar(num1, num2);
                System.out.println("Resultado: " + resultado);
                break;
            case '/':
                resultado = dividir(num1, num2);
                if (!Double.isNaN(resultado)) {
                    System.out.println("Resultado: " + resultado);
                }
                break;
            default:
                System.out.println("Operación no válida.");
                break;
        }

        sc.close();
    }
}

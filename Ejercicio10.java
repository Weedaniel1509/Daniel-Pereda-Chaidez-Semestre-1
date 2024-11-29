import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        short cantidad = s.nextShort();

        short contador = 1;
        while (contador <= cantidad) {
            for (short subContador = 0; subContador < contador; subContador++) {
                System.out.print("*");
            }
            System.out.println();
            contador++;
        }

        contador = (short) (cantidad - 1);
        while (contador > 0) {
            for (short subContador = 0; subContador < contador; subContador++) {
                System.out.print("*");
            }
            System.out.println();
            contador--;
        }
    }
}

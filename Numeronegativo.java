// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Numeronegativo {
   public Numeronegativo() {
   }

   public static void main(String[] args) {
      ArrayList<Integer> numeros = new ArrayList();
      Scanner scanner = new Scanner(System.in);

      int numero;
      do {
         System.out.print("Ingresa un n\u00famero entero (n\u00famero negativo para salir): ");
         numero = scanner.nextInt();
         if (numero >= 0 && !numeros.contains(numero)) {
            numeros.add(numero);
         }
      } while(numero >= 0);

      int suma = 0;

      int num;
      for(Iterator var6 = numeros.iterator(); var6.hasNext(); suma += num) {
         num = (Integer)var6.next();
      }

      System.out.println("La suma de los n\u00fameros es: " + suma);
      scanner.close();
   }
}

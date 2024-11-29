// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Scanner;

public class ExamenEstructuraSelectiva {
   public ExamenEstructuraSelectiva() {
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Ingresa la calificacion del estudiante: ");
      int calificacion = scanner.nextInt();
      if (calificacion >= 70) {
         if (calificacion >= 90) {
            System.out.println("Felicidades, haz aprobado con buena calificacion.");
         } else {
            System.out.println("Aprobaste. Pero puedes mejorar");
         }
      } else {
         System.out.println("No aprobaste, echale mas ganas.");
      }

      scanner.close();
   }
}

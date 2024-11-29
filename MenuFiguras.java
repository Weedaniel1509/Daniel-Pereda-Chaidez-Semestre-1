// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Scanner;

public class MenuFiguras {
   public MenuFiguras() {
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      int opcion;
      do {
         System.out.println("Men\u00fa de Figuras:");
         System.out.println("1. Tri\u00e1ngulo");
         System.out.println("2. Cuadrado");
         System.out.println("3. C\u00edrculo");
         System.out.println("4. Rect\u00e1ngulo");
         System.out.println("5. Salir");
         System.out.print("Seleccione una opci\u00f3n: ");
         opcion = scanner.nextInt();
         switch (opcion) {
            case 1:
               System.out.print("Ingrese la base del tri\u00e1ngulo: ");
               double baseTriangulo = scanner.nextDouble();
               System.out.print("Ingrese la altura del tri\u00e1ngulo: ");
               double alturaTriangulo = scanner.nextDouble();
               double areaTriangulo = baseTriangulo * alturaTriangulo / 2.0;
               System.out.println("El \u00e1rea del tri\u00e1ngulo es: " + areaTriangulo);
               break;
            case 2:
               System.out.print("Ingrese el lado del cuadrado: ");
               double ladoCuadrado = scanner.nextDouble();
               double areaCuadrado = ladoCuadrado * ladoCuadrado;
               System.out.println("El \u00e1rea del cuadrado es: " + areaCuadrado);
               break;
            case 3:
               System.out.print("Ingrese el radio del c\u00edrculo: ");
               double radioCirculo = scanner.nextDouble();
               double areaCirculo = Math.PI * radioCirculo * radioCirculo;
               System.out.println("El \u00e1rea del c\u00edrculo es: " + areaCirculo);
               break;
            case 4:
               System.out.print("Ingrese la base del rect\u00e1ngulo: ");
               double baseRectangulo = scanner.nextDouble();
               System.out.print("Ingrese la altura del rect\u00e1ngulo: ");
               double alturaRectangulo = scanner.nextDouble();
               double areaRectangulo = baseRectangulo * alturaRectangulo;
               System.out.println("El \u00e1rea del rect\u00e1ngulo es: " + areaRectangulo);
               break;
            case 5:
               System.out.println("Saliendo del programa...");
               break;
            default:
               System.out.println("Opci\u00f3n no v\u00e1lida. Int\u00e9ntelo de nuevo.");
         }

         System.out.println();
      } while(opcion != 5);

      scanner.close();
   }
}

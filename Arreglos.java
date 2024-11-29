// Source code is decompiled from a .class file using FernFlower decompiler.
public class Arreglos {
   public Arreglos() {
   }

   public static void main(String[] args) {
      String[] nombres = new String[]{"Carlos", "Ana", "Luis", "Mar\u00eda", "Jorge"};
      String[] var5 = nombres;
      int var4 = nombres.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         String nombre = var5[var3];
         System.out.println("Nombre: " + nombre);
      }

   }
}

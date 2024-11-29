// Source code is decompiled from a .class file using FernFlower decompiler.
public class Objeto5datos {
    public Objeto5datos() {
    }
 
    public static void main(String[] args) {
       Object[] arreglo = new Object[]{10.55, true, "Hola Mundo", 42, 'A'};
       Object[] var5 = arreglo;
       int var4 = arreglo.length;
 
       for(int var3 = 0; var3 < var4; ++var3) {
          Object Object = var5[var3];
          System.out.println(Object);
       }
 
    }
 }
 
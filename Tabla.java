// Source code is decompiled from a .class file using FernFlower decompiler.
public class Tabla {
    public Tabla() {
    }
 
    public static void main(String[] args) {
       int[][] tabla = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
 
       try {
          System.out.println("El valor en (2,0) es: " + tabla[2][0]);
       } catch (ArrayIndexOutOfBoundsException var3) {
          System.out.println("Error: \u00cdndice fuera de los l\u00edmites.");
       }
 
    }
 }
 
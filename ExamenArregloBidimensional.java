// Source code is decompiled from a .class file using FernFlower decompiler.
public class ExamenArregloBidimensional {
    public ExamenArregloBidimensional() {
    }
 
    public static void main(String[] args) {
       char[][] matriz = new char[10][3];
 
       int x;
       int y;
       for(x = 0; x < 10; ++x) {
          for(y = 0; y < 3; ++y) {
             matriz[x][y] = (char)(65 + y);
          }
       }
 
       for(x = 0; x < 10; ++x) {
          for(y = 0; y < 3; ++y) {
             System.out.print(matriz[x][y] + " ");
          }
 
          System.out.println();
       }
 
    }
 }
 
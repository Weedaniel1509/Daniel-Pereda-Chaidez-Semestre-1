// Source code is decompiled from a .class file using FernFlower decompiler.
public class TablaMultiplicar {
    public TablaMultiplicar() {
    }
 
    public static void main(String[] args) {
       int[][] TablaMultiplicar = new int[100][100];
 
       int i;
       int j;
       for(i = 0; i < 100; ++i) {
          for(j = 0; j < 100; ++j) {
             TablaMultiplicar[i][j] = (i + 1) * (j + 1);
          }
       }
 
       for(i = 0; i < 100; ++i) {
          for(j = 0; j < 100; ++j) {
             System.out.printf("%5d", TablaMultiplicar[i][j]);
          }
 
          System.out.println();
       }
 
    }
 }
 
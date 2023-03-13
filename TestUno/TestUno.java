package TestUno;

// Realice un programa en donde se genere un arreglo de n x 10(leer n del teclado) ,y que cada fila sea la tabla de multiplicar(desde 1 hasta n)-cada fila contendrá la tabla de multiplicar del indice de la fila,por ejemplo la fila 2 contendrá la tabla de multiplicar del 2(0,2,4,6,...,18)-mostrándola en forma de tabla.Calcular la sumatoria de aquellos valores cuyos indices(tanto de la fila como de la columna)son impares, así como la suma de valor contenido que sea múltiplo de 4.

import java.util.Scanner;

public class TestUno {
    public static void main(String[] args) {
        int n;
        int countC = 0, countImpar = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("La matriz será de n X 10");
        System.out.print("Digite el valor de n: ");
        n = input.nextInt();

        int array[][] = new int[n][10];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                array[i][j] = (i + 1) * j ;
                if (i % 2 != 0 && j % 2 != 0) {
                    countImpar = countImpar + array[i][j];
                }
                if (array[i][j] % 4 == 0) {
                    countC = countC + array[i][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + array[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("La suma de valores de índice impar es: " + countImpar);
        System.out.println("La suma de valores de índice múltiplo de 4 es: " + countC);
    }
}

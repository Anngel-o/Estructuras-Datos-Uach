package P3DibujarRombo;
import java.util.Scanner;
import javax.swing.JOptionPane;

//Dibujar un rombo con el carácter que ingrese el usuario
public class DibujarRombo {
    static void CreateArray(char array[][], int n, char us) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) { // i-j <= (n/2)
                if (i + j >= (n / 2) && i + (n / 2) >= j && j + (n / 2) >= i && i + j <= (n / 2) + n - 1) {
                    array[i][j] = us;
                } else {
                    array[i][j] = ' ';
                }
            }
        }
    }

    static void PrintArray(char array[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n;
        System.out.print("¿De qué tamaño quieres el arreglo? ");
        n = input.nextInt();
        //n = Integer.parseInt(JOptionPane.showInputDialog(null, "¿De qué tamaño quieres el arreglo?"));
        char array [][] = new char [n][n];
        char us;
        System.out.print("¿De qué carácter quieres llenar el rombo? ");
        us = input.next().charAt(0);
        //us = JOptionPane.showInputDialog(null, "¿De qué carácter quieres llenar el rombo?");

        if(n % 2 != 0) {
            CreateArray(array, n, us);
            PrintArray(array, n);
        }
        else {
            System.out.println("Sólo números impares para dibujar el rombo");
        }
    }
}

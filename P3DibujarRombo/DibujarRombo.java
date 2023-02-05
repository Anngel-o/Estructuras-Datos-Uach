package P3DibujarRombo;
import javax.swing.JOptionPane;

//Dibujar un rombo con el caractér que ingrese el usuario
public class DibujarRombo {
    static void CreateArray(String array[][], int n, String us) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) { // i-j <= (n/2)
                if (i + j >= (n / 2) && i + (n / 2) >= j && j + (n / 2) >= i && i + j <= (n / 2) + n - 1) {
                    array[i][j] = us;
                } else {
                    array[i][j] = "0";
                }
            }
        }
    }

    static void PrintArray(String array[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n;
        n = Integer.parseInt(JOptionPane.showInputDialog(null, "¿De qué tamaño quieres el arreglo?"));
        String array [][] = new String [n][n];
        String us;
        us = JOptionPane.showInputDialog(null, "¿De qué carácter quieres llenar el rombo?");

        CreateArray(array, n, us);
        PrintArray(array, n);
    }
}

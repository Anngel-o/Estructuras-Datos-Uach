package P3DibujarRombo;
import javax.swing.JOptionPane;

public class DibujarRombo {
    //Dibujar un rombo con el caractér que ingrese el usuario
    public static void main(String[] args) {
        int array [][] = new int [5][5];
        int us;
        us = Integer.parseInt(JOptionPane.showInputDialog(null, "¿De qué caractér quieres llenar el arreglo?"));

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = us;
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}

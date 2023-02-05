package P1ModificarArreglo;
import javax.swing.JOptionPane;

/*
 Escribe un programa que genere 100 números aleatorios del 0 al 20 y que los muestre por pantalla separados por espacios. El programa pedirá entonces por teclado dos valores y a continuación cambiará todas las ocurrencias del primer valor por el segundo en la lista generada anteriormente. Los números que se han cambiado deben aparecer entrecomillados.
 */
public class ModificarArreglo {

    static void CreateArray (int array[]) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 20) + 1;
        }
    }

    static void PrintArray(int array []) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    static void ChangeElement(int array[], int i, int b) {
        array[i] = b;
    }

    static void PrintNewArray(int array[], int a, int b) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == a) {
                ChangeElement(array, i, b);
                System.out.print("\"" + array[i] + "\"" + " ");
            }
            else {
                System.out.print(array[i] + " ");
            }
        }
    }
    
    public static void main(String[] args) {
        int array[] = new int[100];
        int a = 0, b = 0;

        CreateArray(array);
        PrintArray(array);

        a = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Qué elemento deseas sustituir?"));
        b = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuál es el nuevo elemento?"));

        if (a <=20 && b <=20) {
            System.out.println();
            System.out.println();
            PrintNewArray(array, a, b);
        }
        else {
            JOptionPane.showConfirmDialog(null, "Debe ser un número de 0 -20");
        }
 
    }
}

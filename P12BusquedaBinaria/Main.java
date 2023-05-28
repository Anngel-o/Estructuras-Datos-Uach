package P12BusquedaBinaria;

//import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String args[]) {
        // Random numeroAleatorio = new Random();
        Arbol arbol = new Arbol();
        int valor, valorAnterior = 0;

        System.out.println("Insertando los siguientes valores: ");

        for (int i = 1; i <= 3; i++) {
            // valor = numeroAleatorio.nextInt(100);
            valor = input.nextInt();
            System.out.print(valor + " ");
            if (valor == valorAnterior) { // Ignora valores repetidos
                i--;
                System.out.println("* Introducir valor diferente");
            } else {
                valorAnterior = valor;
                arbol.insertarNodo(valor);
            }
        }

        System.out.println("Arbol Generado: " + arbol);
        System.out.println("\n\nRecorrido preorden");
        arbol.recorridoPreorden();

        System.out.println("\n\nRecorrido inorden");
        arbol.recorridoInorden();

        System.out.println("\n\nRecorrido postorden");
        arbol.recorridoPostorden();
        System.out.println();
    }
}

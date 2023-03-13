package P7ListasCirculares;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner input = new Scanner(System.in);
        int decision;

        do {
            System.out.println("***** Lista Enlazada Circular *****");
            System.out.println("1. Insertar al frente");
            System.out.println("2. Insertar al final");
            System.out.println("3. Cortar lista");
            System.out.println("4. Tamaño de lista");
            System.out.println("5. Imprimir lista");
            System.out.println("6. Obtener nodo");
            System.out.println("7. Intercambiar nodos");
            System.out.println("8. Salir");
            System.out.println();
            System.out.println("Digita una opción");
            decision = input.nextInt();
            input.nextLine();

            Object element;
            switch (decision) {
                case 1:
                    System.out.println("***** Insertar al frente *****");
                    System.out.println("¿Qué elemento vas a agregar al frente de la lista?");
                    element = input.nextLine();
                    list.addFirst(element);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("***** Insertar al final *****");
                    System.out.println("¿Qué elemento vas a agregar al final de la lista?");
                    element = input.nextLine();
                    list.addLast(element);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("***** Cortar lista *****");
                    System.out.println("¿A partir de qué elemento vas a cortar la lista (posición)?");
                    int cut = input.nextInt();
                    list.cut(cut);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("***** Tamaño de lista *****");
                    System.out.println("Tamaño de lista: " + list.size());
                    System.out.println();
                    break;
                case 5:
                    System.out.println("***** Lista actual *****");
                    list.printList();
                    System.out.println();
                    break;
                case 6:
                    System.out.println("***** Obtener nodo por índice *****");
                    System.out.println("¿Qué nodo deseas obtener (índice)?");
                    int nod = input.nextInt();
                    input.nextLine();
                    System.out.println("Valor del nodo " + nod + ": " + list.getNodo(nod));
                    System.out.println();
                    break;
                case 7:
                    System.out.println("***** Intercambiar nodos *****");
                    System.out.println("¿Qué nodo deseas cambiar (posición)?");
                    int pos1 = input.nextInt();
                    System.out.println("¿Por cuál nodo (posición)?");
                    int pos2 = input.nextInt();
                    list.toExchange(pos1, pos2);
                    System.out.println();
                    break;

                default:
                    break;
            }
        } while (decision != 8);
    }
}

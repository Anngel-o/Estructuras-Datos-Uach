package TestDos;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static int Menu() {
        int opt;
        System.out.println("***** BIENVENIDO A TU EXAMEN DE LISTAS ENLAZADAS *****");
        System.out.println("***** Listas Enlazadas Simples *****");
        System.out.println("1. Insertar al frente");
        System.out.println("2. Insertar al final");
        System.out.println("3. Insertar por índice");
        System.out.println("4. Remover del frente");
        System.out.println("5. Remover del final");
        System.out.println("6. Remover por índice");
        System.out.println("7. Cortar lista");
        System.out.println("8. Tamaño de lista");
        System.out.println("9. Imprimir lista");
        System.out.println("10. Obtener nodo por índice");
        System.out.println("11. Intercambiar nodos");
        System.out.println("12. Salir");
        System.out.println();
        System.out.println(" 88. Examen Práctico");
        System.out.println();
        System.out.println("Digita el número de operación: ");
        opt = input.nextInt();
        input.nextLine();
        return opt;
    }
    public static void main(String[] args) throws Exception{
        try {
            int opt;
            Object element;
            linkedList list = new linkedList();
            do {
                opt = Menu();
                switch (opt) {
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
                        System.out.println("***** Insertar por índice *****");
                        System.out.println("¿Qué elemento vas a agregar?");
                        element = input.nextLine();
                        System.out.println("¿En qué índice?");
                        int index = input.nextInt();
                        list.addForIndex(index, element);
                        System.out.println();
                        break;
                    case 4:
                        System.out.println("***** Remover del frente *****");
                        list.deleteFirst();
                        System.out.println();
                        break;
                    case 5:
                        System.out.println("***** Remover del final *****");
                        list.delete(list.size() - 1);
                        System.out.println();
                        break;
                    case 6:
                        System.out.println("***** Remover por índice *****");
                        System.out.println("¿Qué elemento vas a remover (índice)?");
                        int del = input.nextInt();
                        list.delete(del);
                        System.out.println();
                        break;
                    case 7:
                        System.out.println("***** Cortar lista *****");
                        System.out.println("¿A partir de qué elemento vas a cortar la lista (posición)?");
                        int cut = input.nextInt();
                        list.cut(cut);
                        System.out.println();
                        break;
                    case 8:
                        System.out.println("***** Tamaño de lista *****");
                        System.out.println("Tamaño de lista: " + list.size());
                        System.out.println();
                        break;
                    case 9:
                        System.out.println("***** Lista actual *****");
                        list.printList();
                        System.out.println();
                        break;
                    case 10:
                        System.out.println("***** Obtener nodo por índice *****");
                        System.out.println("¿Qué nodo deseas obtener (índice)?");
                        int nod = input.nextInt();
                        input.nextLine();
                        System.out.println("Valor del nodo " + nod + ": " + list.getNodo(nod));
                        System.out.println();
                        break;
                    case 11:
                        System.out.println("***** Intercambiar nodos *****");
                        System.out.println("¿Qué nodo deseas cambiar (posición)?");
                        int pos1 = input.nextInt();
                        System.out.println("¿Por cuál nodo (posición)?");
                        int pos2 = input.nextInt();
                        list.toExchange(pos1, pos2);
                        System.out.println();
                        break;
                    case 12:
                        System.out.println("Hasta luego!");
                        break;
                    case 88:
                        try {
                            System.out.println(" ****** Operación 88 - Examen Practico *****");
                            list.toChangeNodo();
                            list.printList();
                            System.out.println("Hasta luego!");
                        } catch (RuntimeException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                        
                    default:
                        break;
                }
            } while (opt != 88);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

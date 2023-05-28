package Grafos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Grafo g = new Grafo();
        Scanner sc = new Scanner(System.in);
        String nombre;
        int opcion = 0;

        while (opcion != 99) {
            System.out.println("Favor de elegir una opcion: ");
            System.out.println("1.- Agregar nodo ");
            System.out.println("2.- Mostrar nodos");
            System.out.println("3.- Insertar arista");
            System.out.println("4.- Mostrar Lista de adyacencia");
            System.out.println("5.- Mostrar matriz de adyacencia");
            System.out.println("99.- Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: {
                    System.out.println("Ingrese el  nombre: ");
                    nombre = sc.next();

                    g.agregarNodo(nombre.charAt(0));
                    break;
                }
                case 2: {
                    g.imprimirNodos();
                    break;
                }
                case 3: {
                    String inicio, destino;
                    System.out.println("Ingrese nodo de incio");
                    inicio = sc.next();
                    System.out.println("Ingrese nodo de destino");
                    destino = sc.next();
                    g.agregarArista(inicio.charAt(0), destino.charAt(0));
                    break;
                }
                case 4: {
                    g.imprimirListaAdyacencia();
                    break;
                }
                case 5: {
                    g.imprimirMatriz();
                    break;
                }
                case 99: {
                    System.out.println("Nos vemos!!");
                    break;
                }
                default:
                    System.out.println("Opcion invalida favor de volver a intentarlo");
                    break;
            }
        }

        sc.close();

    }
}

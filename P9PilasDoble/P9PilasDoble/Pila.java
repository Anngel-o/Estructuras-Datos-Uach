package P9PilasDoble;

import java.util.EmptyStackException;
import java.util.Scanner;

public class Pila{
    public static Scanner input = new Scanner(System.in);

    public static int Menu() {
        int opt;
        System.out.println();
        System.out.println("***** BIENVENIDO A TU POKEDEX V 1.0 *****");
        System.out.println(" 1. Registrar un nuevo Pokémon");
        System.out.println(" 2. Consultar información sobre un Pokémon");
        System.out.println(" 3. Consultar los Pokémon registrados");
        System.out.println(" 4. Eliminar último Pokémon");
        System.out.println(" 5. Salir");
        System.out.print("Digita una opción: ");
        opt = input.nextInt();
        input.nextLine();
        return opt;
    }

    static ListaDoble milista;
    public static void main(String args[]) throws Exception{
        try {
            milista = new ListaDoble();
            int opt;
            Object nombre, tipo;
            do {
                opt = Menu();
                switch (opt) {
                    case 1:
                        System.out.println();
                        System.out.println(" *** Registro de un nuevo Pokémon ***");
                        System.out.println();
                        Pokemon pokemon = new Pokemon();
                        System.out.println("Introduce los datos del pokémon: ");
                        System.out.println("Nombre de Pokémon: ");
                        nombre = input.nextLine();
                        pokemon.setNombre(nombre);
                        System.out.println("Tipo de Pokémon: ");
                        tipo = input.nextLine();
                        pokemon.setTipo(tipo);
                        milista.push(pokemon);
                        break;
                    case 2:
                        System.out.println();
                        System.out.println(" *** Consulta si existe un Pokémon ***");
                        System.out.println();
                        System.out.println("Introduce los datos del pokémon: ");
                        System.out.println("Nombre de Pokémon: ");
                        nombre = input.nextLine();
                        milista.search(nombre);
                        break;
                    case 3:
                        try {
                            System.out.println();
                            System.out.println(" *** Tus Pokémon registrados ***");
                            milista.verLista();
                        } catch (EmptyStackException e) {
                            System.out.println("Aún no hay Pokémon registrados" + e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.println();
                        System.out.println(" *** Eliminar último Pokémon ***");
                        milista.pop();
                        break;
                    case 5:
                        System.out.println();
                        System.out.println(" *** Gracias por usar tu Pokedex v1.0 ***");
                        break;
                    default:
                        break;
                }
            } while (opt != 5);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Menu();
        }
    }   
}

package P9PilasDoble;

import java.util.EmptyStackException;

public class ListaDoble {
    private NodoDoble primerNodo;
    private NodoDoble ultimoNodo;
    private int numElem;

    ListaDoble() {
        this.primerNodo = null;
        this.ultimoNodo = null;
        this.numElem = 0;
    }

    // métodos
    public void pop() {
        try {
            // eliminar el nodo al final de la lista
            ultimoNodo = ultimoNodo.getAnt();
            // último nodo ahora es una posición menos
            ultimoNodo.getSig().setAnt(null);
            // último nodo ahora se enlaza con un nodo null
            ultimoNodo.setSig(null);
            numElem--;
            System.out.println("Último Pokémon eliminado");
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void push(Pokemon pokemon) {
        try {
            NodoDoble nuevo = new NodoDoble(pokemon);

            if (primerNodo == null) {
                primerNodo = nuevo;
                primerNodo.setSig(null);
                primerNodo.setAnt(null);
                ultimoNodo = primerNodo;
            } else {
                ultimoNodo.setSig(nuevo);
                nuevo.setAnt(ultimoNodo);
                nuevo.setSig(null);
                ultimoNodo = nuevo;
            }
            numElem++;
            System.out.println("Pokémon agregado");
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void verLista() throws Exception{
        System.out.println("Pokémon registrados: " + numElem);
        NodoDoble actual = primerNodo;
        if (!stackEmpty()) {
            while (actual != null) { // Recorrer la lista
                System.out.println(actual.getInfo() + " ");
                actual = actual.getSig();
            }
        }
        else {
            throw new EmptyStackException();
        }
        System.out.println();
    }

    public void search(Object nombre){
        try {
            NodoDoble actual = primerNodo;
            actual.setNamePokemon(nombre);

            while (!stackEmpty()) { // Recorrer la lista
                if (actual.getNamePokemon().equals(nombre)) {
                    System.out.println(actual.getInfo());
                    return;
                } else {
                    actual = actual.getSig();
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
    }

    public boolean stackEmpty() {
        return (numElem == 0) ? true : false;
    }

    public NodoDoble headStack() {
        return ultimoNodo;
    }

    public NodoDoble getPrimerNodo() {
        return primerNodo;
    }

    public void setPrimerNodo(NodoDoble nodo) {
        primerNodo = nodo;
    }

    public NodoDoble getUltimoNodo() {
        return ultimoNodo;
    }

    public int getNumElem() {
        return numElem;
    }
}

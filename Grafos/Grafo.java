package Grafos;

class Grafo {
    private Nodo primerNodo = null;

    public void agregarNodo(char nombre) {
        Nodo nuevoNodo = new Nodo(nombre);
        boolean existe = false;
        if (primerNodo == null) {
            primerNodo = nuevoNodo;
        } else {
            Nodo actual = primerNodo;
            while (actual.getSiguiente() != null) {
                if (actual.getNombre() == nombre) {
                    existe = true;
                }
                actual = actual.getSiguiente();

            }
            if (!existe) {
                actual.setSiguiente(nuevoNodo);

                System.out.println("Nodo insertado!!");
            } else {
                System.out.println("El nodo ya existe en el grafo");
            }
        }
    }

    public void imprimirNodos() {
        if (primerNodo == null) {
            System.out.println("El Grafo no tiene nodos");
        } else {
            Nodo actual = primerNodo;
            while (actual.getSiguiente() != null) {
                System.out.println(actual.getNombre());
                actual = actual.getSiguiente();
            }

            System.out.println(actual.getNombre());
        }
    }

    private Nodo buscarNodo(char nombre) {
        Nodo actual = primerNodo;

        while (actual.getSiguiente() != null) {
            if (actual.getNombre() == nombre) {
                return actual;
            }
            actual = actual.getSiguiente();

        }

        if (actual.getNombre() == nombre) {
            return actual;
        }

        return null;
    }

    public void agregarArista(char inicio, char destino) {
        Nodo nodoInicial;
        Nodo nodoDestino;

        nodoInicial = buscarNodo(inicio);
        if (nodoInicial == null) {
            System.out.println("El nodo de incio no existe");
            return;
        }
        nodoDestino = buscarNodo(destino);
        if (nodoDestino == null) {
            System.out.println("El nodo de destino no existe");
            return;
        }

        Arista nuevaArista = new Arista(nodoDestino);
        if (nodoInicial.getSigArista() == null) {
            nodoInicial.setSigArista(nuevaArista);
            System.out.println("Arista insertada!!");
        } else {
            Arista actual = nodoInicial.getSigArista();
            while (actual.getSigArista() != null) {
                actual = actual.getSigArista();
            }
            actual.setSigArista(nuevaArista);
            System.out.println("Arista insertada!!");
        }
    }

    public void imprimirListaAdyacencia() {
        Nodo actual = primerNodo;
        Arista aristaActual = null;
        System.out.println("Nodo | Lista");
        while (actual.getSiguiente() != null) {
            aristaActual = actual.getSigArista();
            System.out.print("   " + actual.getNombre() + "|");
            if (aristaActual != null) {
                while (aristaActual != null) {
                    System.out.print(" " + aristaActual.getDestino().getNombre());
                    aristaActual = aristaActual.getSigArista();

                }
            }

            actual = actual.getSiguiente();
            System.out.println("");
        }
        aristaActual = actual.getSigArista();
        System.out.print("   " + actual.getNombre() + "|");
        if (aristaActual != null) {
            while (aristaActual != null) {
                System.out.print(" " + aristaActual.getDestino().getNombre());
                aristaActual = aristaActual.getSigArista();

            }
        }
        System.out.println("");
    }

    private boolean buscarArista(Nodo nodo, char busqueda) {
        if (nodo.getSigArista() == null) {
            return false;
        }
        Arista actual = nodo.getSigArista();
        while (actual.getSigArista() != null) {
            if (actual.getDestino().getNombre() == busqueda) {
                return true;
            }
            actual = actual.getSigArista();
        }
        if (actual.getDestino().getNombre() == busqueda) {
            return true;
        }
        return false;
    }

    public void imprimirMatriz() {
        Nodo actual = primerNodo;
        System.out.print("Nodo | ");

        while (actual.getSiguiente() != null) {
            System.out.print(actual.getNombre() + " | ");
            actual = actual.getSiguiente();
        }

        System.out.println(actual.getNombre() + " | ");

        actual = primerNodo;

        while (actual.getSiguiente() != null) {
            Nodo aux = primerNodo;
            System.out.print(actual.getNombre() + "   | ");
            while (aux.getSiguiente() != null) {
                if (buscarArista(actual, aux.getNombre())) {
                    System.out.print(" 1 ");
                } else {
                    System.out.print(" 0 ");
                }
                aux = aux.getSiguiente();
            }
            if (buscarArista(actual, aux.getNombre())) {
                System.out.println(" 1 ");
            } else {
                System.out.println(" 0 ");
            }
            actual = actual.getSiguiente();
        }
        Nodo aux = primerNodo;
        System.out.print(actual.getNombre() + "   | ");
        while (aux.getSiguiente() != null) {
            if (buscarArista(actual, aux.getNombre())) {
                System.out.print(" 1 ");
            } else {
                System.out.print(" 0 ");
            }
            aux = aux.getSiguiente();
        }
        if (buscarArista(actual, aux.getNombre())) {
            System.out.println(" 1 ");
        } else {
            System.out.println(" 0 ");
        }
    }

}
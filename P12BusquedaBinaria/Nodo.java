package P12BusquedaBinaria;

class Nodo {
    Nodo nodoIzq;
    Nodo nodoDer;
    int datos;

    public Nodo(int datosNodo) {
        this.datos = datosNodo;
        this.nodoIzq = nodoDer = null;
    }

    public void insertar(int valorInsertar) {
        // inserta en el subarbol izquierdo
        if (valorInsertar < datos) {
            // inserta nuevo NodoArbol
            if (nodoIzq == null)
                nodoIzq = new Nodo(valorInsertar);
            else // continua recorriendo el subarbol izquierdo
                nodoIzq.insertar(valorInsertar);
        } else if (valorInsertar > datos) // inserta en el subarbol derecho
        {
            // inserta nuevo NodoArbol
            if (nodoDer == null)
                nodoDer = new Nodo(valorInsertar);
            else // continua recorriendo el subarbol derecho
                nodoDer.insertar(valorInsertar);
        }
    }
}

package P11Arbol;

public class Arbol {
    private Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    // inserta un nuevo nodo en el arbol de busqueda binaria
    public void insertarNodo(int valorInsertar) {
        if (raiz == null)
            raiz = new Nodo(valorInsertar); // crea el nodo raiz
        else
            raiz.insertar(valorInsertar);
    }

    public void recorridoPreorden() {
        ayudantePreorden(raiz);
    }

    private void ayudantePreorden(Nodo nodo) {
        if (nodo == null)
            return;

        System.out.printf("%d ", nodo.datos); // imprime los datos del nodo
        ayudantePreorden(nodo.nodoIzq); // recorre el subarbol izquierdo
        ayudantePreorden(nodo.nodoDer); // recorre el subarbol derecho
    }

    public void recorridoInorden() {
        ayudanteInorden(raiz);
    }

    private void ayudanteInorden(Nodo nodo) {
        if (nodo == null)
            return;

        ayudanteInorden(nodo.nodoIzq); // recorre el subarbol izquierdo
        System.out.printf("%d ", nodo.datos); // imprime los datos del nodo
        ayudanteInorden(nodo.nodoDer); // recorre el subarbol derecho
    }

    public void recorridoPostorden() {
        ayudantePostorden(raiz);
    }

    private void ayudantePostorden(Nodo nodo) {
        if (nodo == null)
            return;

        ayudantePostorden(nodo.nodoIzq); // recorre el subarbol izquierdo
        ayudantePostorden(nodo.nodoDer); // recorre el subarbol derecho
        System.out.printf("%d ", nodo.datos); // imprime los datos del nodo
    }
}

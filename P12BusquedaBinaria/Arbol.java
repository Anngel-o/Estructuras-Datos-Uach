package P12BusquedaBinaria;

public class Arbol {
    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    // inserta un nuevo nodo en el arbol de busqueda binaria
    public void insertarNodo(int valorInsertar) {
        if (raiz == null)
            raiz = new Nodo(valorInsertar); // crea el nodo raiz
        else
            raiz.insertar(valorInsertar);
    }

    int busqueda(Class arbol * hoja, int num)
    {
        /*se declara una sentencia de control de flujo de tipo ciclo "while" cuya condición de 
        control es que existan hojas en la copia del árbol con la que trabaja el método.*/
        while(hoja)
        {
            /*se declara una sentencia de control de flujo tipo selección "if" cuya 
            condición de control es que el número que se pasó como parámetro sea igual 
            a la propiedad "dato" de la hoja del árbol. Si esta condición se cumple el 
            método regresa el valor constante "VERDADERO", que significa que el dato buscado
            fue encontrado.*/
            if( num==hoja->dato ) return VERDADERO;
            /*si no, la ""copia"" de la hoja del árbol se recorre a otra hoja reasignando su
            referencia según el número, (que se pasó como parámetro) sea menor o mayor a la propiedad
            "dato" de la hoja actual. Si este es menor, la referencia se recorre al hijo izquierdo de 
            la hoja actual; si es mayor, se recorre al hijo derecho de la hoja actual.
            Después se vuelve a iterar el ciclo while, y este mismo proceso se repetirá hasta que ya
            no existan más hojas que recorrer.*/
            else
            {
                if( num<hoja->dato ) hoja= hoja->izq;
                else hoja= hoja->der;
            }
        }
        /*Si desde un principio la copia del árbol está vacía (no existen hojas) el método regresa 
        el valor constante "FALSO".*/
        return FALSO;
    }

    public Nodo busquedaNodo(int valor) {
        Nodo aux = raiz;
        while (aux.datos != valor) {
            if (valor < aux.datos) {
                aux = aux.nodoIzq;
            } else {
                aux = aux.nodoDer;
            }
            if (aux == null) {
                return null;
            }
        }
        return aux;
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

package P7ListasCirculares;

public class Nodo {
    Object value; //Valor del nodo
    Nodo next; //Puntero al nodo siguiente

    Nodo() {

    }
    
    Nodo(Object value) {
        this.value = value;
        this.next = null;
    }

    public Object getValue() { // Obtener el valor del nodo
        return value;
    }

    public void linkNext(Nodo nodo) { // Enlazar al siguiente nodo
        next = nodo; // Apunta a nodo
    }

    public Nodo getNext() { // Obtener el valor de nodo siguiente
        return next;
    }
}

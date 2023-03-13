package P6ListasEnlazadas;

public class Nodo {
    Object value; //Elemento para guardar un valor
    Nodo next; //Puntero al nodo siguiente
    //Nodo anterior; //Para dobles enlazadas

    Nodo() {
        
    }
    Nodo(Object value) {
        this.value = value;
        this.next = null;
    }

    public Object getValue() { //Obtener el valor del nodo
        return value;
    }

    public void linkNext(Nodo nodo) { //Enlazar al siguiente nodo
        next = nodo; //Apunta a nodo
    }

    public Nodo getNext() { //Obtener el valor de nodo siguiente
        return next;
    }
}

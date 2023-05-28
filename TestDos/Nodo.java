package TestDos;

public class Nodo {
    Object info;
    Nodo next;

    public Nodo() {
    }
    public Nodo(Object info) {
        this.info = info;
        this.next = null;
    }
    public Object getInfo() {
        return info;
    }
    public Nodo getNext() {
        return next;
    }
    public void setNext(Nodo next) {
        this.next = next;
    }
}

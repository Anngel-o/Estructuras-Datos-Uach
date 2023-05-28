package Grafos;

class Nodo {
    private char nombre;
    private Nodo siguiente;
    private Arista sigArista;

    public Nodo(char nombre) {
        this.nombre = nombre;
        this.sigArista = null;
        this.siguiente = null;
    }

    public char getNombre() {
        return nombre;
    }

    public void setNombre(char nombre) {
        this.nombre = nombre;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Arista getSigArista() {
        return sigArista;
    }

    public void setSigArista(Arista sigArista) {
        this.sigArista = sigArista;
    }
}

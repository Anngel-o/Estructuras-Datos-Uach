package Grafos;

class Arista {
    private Nodo destino;
    private Arista sigArista;

    public Arista(Nodo destino) {
        this.destino = destino;
        this.sigArista = null;
    }

    public Nodo getDestino() {
        return destino;
    }

    public void setDestino(Nodo destino) {
        this.destino = destino;
    }

    public Arista getSigArista() {
        return sigArista;
    }

    public void setSigArista(Arista sigArista) {
        this.sigArista = sigArista;
    }

}

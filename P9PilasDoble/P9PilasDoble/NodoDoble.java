package P9PilasDoble;

public class NodoDoble {
    private NodoDoble sig;
    private NodoDoble ant;
    private Object info;
    private Object namePokemon;

    NodoDoble() {
    }

    NodoDoble(Pokemon pokemon) {
        this.info = pokemon;
        this.namePokemon = pokemon.getNombre();
        this.sig = null;
        this.ant = null;
    }

    public NodoDoble getSig() {
        return sig;
    }

    public NodoDoble getAnt() {
        return ant;
    }

    public void setSig(NodoDoble sig) {
        this.sig = sig;
    }

    public void setAnt(NodoDoble ant) {
        this.ant = ant;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public Object getNamePokemon() {
        return namePokemon;
    }

    public void setNamePokemon(Object namePokemon) {
        this.namePokemon = namePokemon;
    }
}

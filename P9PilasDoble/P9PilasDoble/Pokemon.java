package P9PilasDoble;

public class Pokemon {
    Object nombre;
    Object tipo;
    public Pokemon() {
    }
    public Pokemon(Object nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }
    public Object getNombre() {
        return nombre;
    }
    public void setNombre(Object nombre) {
        this.nombre = nombre;
    }
    public Object getTipo() {
        return tipo;
    }
    public void setTipo(Object tipo) {
        this.tipo = tipo;
    }
    @Override
    public String toString() {
        return "Pokemon [nombre = " + nombre + ", tipo = " + tipo + "]";
    }
}

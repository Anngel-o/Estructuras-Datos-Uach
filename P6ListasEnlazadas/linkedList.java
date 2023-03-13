package P6ListasEnlazadas;

public class linkedList {
    Nodo head; // Nodo cabeza punto de partida para recorrer la lista
    int size;

    public linkedList() {
        head = null; //Es nula ya que aún no hay elementos en la lista
        size = 0;
    }

    public Object getNodo(int index) { //Obtener un nodo por índice
        int count = 0;  
        Nodo tempNodo = head;

        while (count < index) {
            tempNodo = tempNodo.getNext();
            count++;
        }
        return tempNodo.getValue();
        // Iteramos desde count (0) hasta index (parámetro) y nodo temporal se convierte en el nodo siguiente hasta encontrar el nodo ubicado en index
    }

    public void addFirst(Object obj) {
        // Si el nodo cabeza está vacío (apunta a null) se instanciará como un nuevo nodo con un objeto dado por parámetro
        if (head == null) {
            head = new Nodo(obj);
        } else {
            Nodo tempNodo = head;
            Nodo newNodo = new Nodo(obj);
            newNodo.linkNext(tempNodo);
            head = newNodo;
            // si ya existe un elemento de cabecera el nuevo nodo se instancia aislado de la lista por lo que lo enlazamos al nodo temporal el cual apunta a nodo cabecera, así nodo nuevo se queda de nodo cabecera
        }
        size++; // Determinar el tamanio de la lista
    }

    public void addLast(Object obj) {
        // Si el nodo cabeza está vacío (apunta a null) se instanciará como un nuevo
        // nodo con un objeto dado por parámetro
        if (head == null) {
            head = new Nodo(obj);
        } else {
            Nodo tempNodo = head;
            Nodo currentLast = tempNodo;

            while (tempNodo != null) {
                currentLast = tempNodo;
                tempNodo = tempNodo.getNext();
            }

            Nodo newNodo = new Nodo(obj);
            currentLast.linkNext(newNodo);
            // si ya existe un elemento de cabecere el último nodo actual apunta a nodo temporal quien a su vez apunta a nodo cabecera. Mientras nodo temporal (cabecera) sea distinto de null el último nodo actual apunta a nodo temporal, después se instancia un nodo nuevo y se enlaza con nodo último actual
        }
        size++;// Determinar el tamanio de la lista
    }

    public void addForIndex(int index, Object obj) {
        // Primero con un if verificamos que exista ese índice en la lista (por ejemplo si la lista tiene 4 nodos podemos insertar hasta la posición 5, es decir uno más allá del último)
        if (index <= size() + 1) {
            Nodo newNodo = new Nodo(obj);
            if (index == 0) { //Inserta al principio
                addFirst(obj);
            } else if (index == size() + 1) { //Inserta al final
                addLast(obj);
            } else { //Inserta al medio
                Nodo tempNodo = head;
                // nos detenemos una posición antes a donde tenemos que insertarlo
                for (int i = 1; i <= index - 1; i++)
                    tempNodo = tempNodo.getNext();
                Nodo insert = tempNodo.getNext();
                //Se apunta al nodo en la siguiente posición del nodo temporal que guarda la ultima posición en la que se quedó (dado por index)
                tempNodo.linkNext(newNodo);
                //Nodo temporal se enlaza con el nuevo nodo
                newNodo.linkNext(insert);
                //Nuevo nodo se enlaza con el nodo insertado

                // tempNodo.next = newNodo;
                // newNodo.next = nodo;
            }
        }
    }

    public void toExchange(int pos1, int pos2) {
        //Verificar que las dos posiciones existan
        if (pos1 <= size() && pos2 <= size()) {
            Nodo reco1 = head;
            //Recorremos los nodos hasta llegar a las posiciones
            for (int i = 1; i < pos1; i++)
                reco1 = reco1.getNext();
            Nodo reco2 = head;
            for (int i = 1; i< pos2; i++)
                reco2 = reco2.next;
            //Se intercambian los valores
            Object aux = reco1.getValue();
            reco1.value = reco2.value;
            reco2.value = aux;
        }
    }

    public void moveAtPosition(int element, int pos) {
        //Verificar que las dos posiciones existan
        int count = 0;
        Nodo tempNodo = head;

        if (element <= size() && pos <= size()) {
            Nodo newNodo = new Nodo();
            //Recorremos los nodos
            while (count < pos) {
                tempNodo = tempNodo.getNext();
                count++;
                if (element == pos - 1) {
                    
                    // nos detenemos una posición antes a donde tenemos que insertarlo
                    for (int i = 1; i <= pos - 1; i++)
                        tempNodo = tempNodo.next;
                    Nodo insert = tempNodo.next;
                    // Se apunta al nodo en la siguiente posición del nodo temporal que guarda la
                    // ultima posición en la que sxe quedó (dado por index)
                    tempNodo.linkNext(newNodo);
                    // Nodo temporal se enlaza con el nuevo nodo
                    newNodo.linkNext(insert);
                    // Nuevo nodo se enlaza con el nodo insertado
                }
            } 
        }
    }

    public int size() {
        return size;
    }

    public void deleteFirst() {
        System.out.println("Se eliminó " + head.getValue());
        head = head.getNext(); //El nodo cabeza será el nodo siguiente
        size--; //El tamanio se reduce
    }

    public void delete(int index) {
        Nodo tempNodo = head;
        //Reenlazar elementos 1 -> 2 -> 3 ---- 1 -> 3
        if (index == 0) {
            head = head.getNext();
        }
        else {
            int count = 0;
            
            while (count < index) {
                tempNodo = tempNodo.getNext();
                count++;
            }
            tempNodo.linkNext(tempNodo.getNext().getNext());
        } 
        System.out.println("Se eliminó: " + tempNodo.getValue());
        size--;
        // Iteramos desde count (0) hasta index - 1(parámetro) y nodo temporal se convierte en su nodo siguiente para recorrer la lista y encontrar el índice a eliminar, después nodo temporal se enlaza con sus dos nodos siguientes ya que el siguiente es el que se "elimina"
    }

    public void cut(int index) {
        // "Eliminar" los elementos a partir de cierto nodo
        int count = 0;
        Nodo tempNodo = head;
        while (count < index - 1) {
            tempNodo = tempNodo.getNext();
            count++;
        }
        tempNodo.linkNext(null);
        size = index;
        // Recorremos la lista desde el primer elemento (índice 0) hasta index
        // (parámetro) donde nodo temporal será su nodo siguiente en cada iteración
        // hasta encontrar index y después enlazamos nodo temporal a null para que
        // desaparezcan los elementos siguientes
    }

    public boolean isEmpty() {
        return (head == null)?true:false;
        //Si el nodo cabeza está vacío (apunta a null) devuelve true
    }

    public void printList() {
        Nodo current = head; //nodo actual apunta a nodo cabeza
        if (isEmpty()) {
            System.out.println("Vacía");
        }

        while(current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
        //Se crea un nodo actual que nos ayudará a recorrer la lista, mientras nodo actual (apunta a nodo cabeza) tiene valor distinto de null se imprime su valor mientras va cambiando a nodo siguiente para seguir recorriendo la lista
    }
}

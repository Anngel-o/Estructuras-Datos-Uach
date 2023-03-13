package P7ListasCirculares;

public class LinkedList {
    Nodo head; // Nodo cabeza punto de partida para recorrer la lista
    Nodo last;
    int size;

    public LinkedList() {
        head = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (head == null) ? true : false;
        // Si el nodo cabeza está vacío (apunta a null) devuelve true
    }

    public Object getNodo(int index) { // Obtener un nodo por índice
        int count = 0;
        Nodo tempNodo = head;

        while (count < index) {
            tempNodo = tempNodo.getNext();
            count++;
        }
        return tempNodo.getValue();
        // Iteramos desde count (0) hasta index (parámetro) y nodo temporal se convierte
        // en el nodo siguiente hasta encontrar el nodo ubicado en index
    }

    public void addFirst(Object obj) {
        // Si el nodo cabeza está vacío (apunta a null) se instanciará como un nuevo
        // nodo con un objeto dado por parámetro
        Nodo newNodo = new Nodo(obj);
        if (head == null) {
            head = newNodo;
            last = newNodo;
            last.linkNext(head);
        } else {
            
            newNodo.linkNext(head); // nuevo nodo se enlaza con head
            head = newNodo;
            last.linkNext(head);  
            // si ya existe un elemento de cabecera el nuevo nodo se instancia aislado de la
            // lista por lo enlazamos con el primer nodo
            //Nuestro primer nodo será el nuevo nodo
            //El último nodo se enlaza con el primero
        }
        size++; // Determinar el tamanio de la lista
    }

    public void addLast(Object obj) {
        // Si el nodo cabeza está vacío (apunta a null) se instanciará como un nuevo
        // nodo con un objeto dado por parámetro
        Nodo newNodo = new Nodo(obj);
        if (head == null) {
            head = newNodo;
            last = newNodo;
            last.linkNext(head);
        } else {
            last.linkNext(newNodo);
            newNodo.linkNext(head);
            
            last = newNodo;
            //Nuestro último nodo se enlaza con el nuevo, el nuevo nodo se enlaza con el primero
            //último nodo será nuestro nuevo nodo
        }
        size++;// Determinar el tamanio de la lista
    }

    public void toExchange(int pos1, int pos2) {
        // Verificar que las dos posiciones existan
        if (pos1 <= size() && pos2 <= size()) {
            Nodo reco1 = head;
            // Recorremos los nodos hasta llegar a las posiciones
            for (int i = 1; i < pos1; i++)
                reco1 = reco1.getNext();
            Nodo reco2 = head;
            for (int i = 1; i < pos2; i++)
                reco2 = reco2.next;
            // Se intercambian los valores
            Object aux = reco1.getValue();
            reco1.value = reco2.value;
            reco2.value = aux;
        }
    }

    public void cut(int index) {
        // "Eliminar" los elementos a partir de cierto nodo
        int count = 0;
        Nodo tempNodo = head;
        while (count < index - 1) {
            tempNodo = tempNodo.getNext();
            count++;
        }
        tempNodo.linkNext(head);
        size = index;
        // Recorremos la lista desde el primer elemento (índice 0) hasta index
        // (parámetro) donde nodo temporal será su nodo siguiente en cada iteración
        // hasta encontrar index y después enlazamos nodo temporal a null para que
        // desaparezcan los elementos siguientes
    }

    public void printList() {
        Nodo current = head; // nodo actual apunta a nodo cabeza
        
        if (isEmpty()) {
            System.out.println("Vacía");
        }
        int i = 0;
        do {
            System.out.println(i + ": " +current.getValue() + " ");
            current = current.getNext();
            i++;
        }
        while (current != head);
        System.out.println();
        // Se crea un nodo actual que nos ayudará a recorrer la lista, mientras nodo
        // actual (apunta a nodo cabeza) tiene valor distinto de null se imprime su
        // valor mientras va cambiando a nodo siguiente para seguir recorriendo la lista
    }
}

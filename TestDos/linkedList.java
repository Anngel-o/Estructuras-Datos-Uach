package TestDos;

public class linkedList {
    Nodo head;
    int size;

    public linkedList() {
        head = null; 
        size = 0;
    }

    /*
     * EXAMEN PRÁCTICO: Modificar cualquier ejemplo de listas, agrega una función
     * que INTERCAMBIE EL PRIMER NODO POR EL ÚLTIMO (NO LOS VALORES, SINO LOS
     * NODOS). (VALOR 20 PUNTOS), todo en una sola operación del menú (número 88)
     * que se llame "Examen Practico".
     */

    //MÉTODO INTERCAMBIAR PRIMER NODO POR EL ÚLTIMO:
    public void toChangeNodo() throws Exception{
        if (!isEmpty()) {
            Nodo tempNodo = head;
            Nodo currentLast = tempNodo;

            while (tempNodo != null) {
                currentLast = tempNodo;
                tempNodo = tempNodo.getNext();
            }
            
            currentLast.setNext(head.getNext()); //3 -->2
            currentLast.getNext().setNext(head); // 2 -->1
            head = currentLast; 
        }
        else {
            throw new RuntimeException("Lista vacía");
        }
    }

    public Object getNodo(int index) { 
        int count = 0;
        Nodo tempNodo = head;

        while (count < index) {
            tempNodo = tempNodo.getNext();
            count++;
        }
        return tempNodo.getInfo();
    }

    public void addFirst(Object obj) {
        if (head == null) {
            head = new Nodo(obj);
        } else {
            Nodo tempNodo = head;
            Nodo newNodo = new Nodo(obj);
            newNodo.setNext(tempNodo);
            head = newNodo;
        }
        size++; 
    }

    public void addLast(Object obj) {
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
            currentLast.setNext(newNodo);
        }
        size++;
    }

    public void addForIndex(int index, Object obj) {
        if (index <= size() + 1) {
            Nodo newNodo = new Nodo(obj);
            if (index == 0) { // Inserta al principio
                addFirst(obj);
            } else if (index == size() + 1) { // Inserta al final
                addLast(obj);
            } else { // Inserta al medio
                Nodo tempNodo = head;
                for (int i = 1; i <= index - 1; i++)
                    tempNodo = tempNodo.getNext();
                Nodo insert = tempNodo.getNext();
                tempNodo.setNext(newNodo);
                newNodo.setNext(insert);
            }
        }
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
            Object aux = reco1.getInfo();
            reco1.info = reco2.info;
            reco2.info = aux;
        }
    }

    public int size() {
        return size;
    }

    public void deleteFirst() {
        System.out.println("Se eliminó " + head.getInfo());
        head = head.getNext(); 
        size--; 
    }

    public void delete(int index) {
        Nodo tempNodo = head;
        // Reenlazar elementos 1 -> 2 -> 3 ---- 1 -> 3
        if (index == 0) {
            head = head.getNext();
        } else {
            int count = 0;

            while (count < index) {
                tempNodo = tempNodo.getNext();
                count++;
            }
            tempNodo.setNext(tempNodo.getNext().getNext());
        }
        System.out.println("Se eliminó: " + tempNodo.getInfo());
        size--;
    }

    public void cut(int index) {
        // "Eliminar" los elementos a partir de cierto nodo
        int count = 0;
        Nodo tempNodo = head;
        while (count < index - 1) {
            tempNodo = tempNodo.getNext();
            count++;
        }
        tempNodo.setNext(null);
        size = index;
    }

    public boolean isEmpty() {
        return (head == null) ? true : false;
    }

    public void printList() {
        Nodo current = head; 
        if (isEmpty()) {
            System.out.println("Vacía");
        }

        while (current != null) {
            System.out.print(current.getInfo() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}

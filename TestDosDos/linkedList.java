package TestDosDos;

public class linkedList {
    Nodo head; 
    Nodo last;
    int size;

    public linkedList() {
        head = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (head == null) ? true : false;
    }

    // Realice un ejemplo que en una lista circular inserte un valor (aleatorio menor a 50) en la posición 5 (10 puntos) y elimine el nodo numero 3 (10 puntos), todo en una sola operación del menú (número 88) que se llame "Examen Practico".
    public void examenPractico() {
        addLast(1);
        addLast(2);
        addLast(3);
        addLast(4);

        System.out.println("Lista generada: ");
        printList();
        Object obj = Math.ceil(Math.random() * 49);
        
        System.out.println("Añadiendo número aleatorio menor a 50 en la posición 5 (índice 4): ");
        addForIndex(5, obj);
        printList();
        
        System.out.println("Eliminando la posición 3 (índice 2): ");
        delete(2);
        printList();
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

    public void delete(int index) {
        Nodo tempNodo = head;
        // Reenlazar elementos 1 -> 2 -> 3 ---- 1 -> 3
        if (index == 0) {
            head = head.getNext();
        } else {
            int count = 0;

            while (count < index - 1) {
                tempNodo = tempNodo.getNext();
                count++;
            }
            tempNodo.setNext(tempNodo.getNext().getNext());
        }
        size--;
    }

    public void addFirst(Object obj) {
        Nodo newNodo = new Nodo(obj);
        if (head == null) {
            head = newNodo;
            last = newNodo;
            last.setNext(head);
        } else {

            newNodo.setNext(head); 
            head = newNodo;
            last.setNext(head);
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
                insert.setNext(head);
            }
        }
    }
    public void addLast(Object obj) {
        Nodo newNodo = new Nodo(obj);
        if (head == null) {
            head = newNodo;
            last = newNodo;
            last.setNext(head);
        } else {
            last.setNext(newNodo);
            newNodo.setNext(head);

            last = newNodo;
        }
        size++;
    }

    public void toExchange(int pos1, int pos2) {
        if (pos1 <= size() && pos2 <= size()) {
            Nodo reco1 = head;

            for (int i = 1; i < pos1; i++)
                reco1 = reco1.getNext();
            Nodo reco2 = head;
            for (int i = 1; i < pos2; i++)
                reco2 = reco2.next;

            Object aux = reco1.getInfo();
            reco1.info = reco2.info;
            reco2.info = aux;
        }
    }

    public void cut(int index) {
        int count = 0;
        Nodo tempNodo = head;
        while (count < index - 1) {
            tempNodo = tempNodo.getNext();
            count++;
        }
        tempNodo.setNext(head);
        size = index;
    }

    public void printList() {
        Nodo current = head; 

        if (isEmpty()) {
            System.out.println("Vacía");
        }
        int i = 0;
        do {
            System.out.println(i + ": " + current.getInfo() + " ");
            current = current.getNext();
            i++;
        } while (current != head);
        System.out.println();
    }
}

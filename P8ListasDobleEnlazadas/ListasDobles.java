import java.util.*;
public class ListasDobles {
	private static Scanner input = new Scanner(System.in);

	public static int Menu() {
		int opt;
		System.out.println("***** Lista Doblemente Enlazada *****");
		System.out.println("1. Imprimir lista existente");
		System.out.println("2. Revertir lista existente");
		System.out.println("3. Mover nodo de posición");
		System.out.println("4. Modificar nodo");
		System.out.println("5. Salir");
		System.out.print("Digita una opción: ");
		opt = input.nextInt();
		input.nextLine();
		return opt;
	}

	public static void main(String[] args) {
		int opt = 0;
		//int info;
		ListaDoble milista = new ListaDoble();

		milista.agregarNodo(5);
		milista.agregarNodo(4);
		milista.agregarNodo(3);
		milista.agregarNodo(2);
		milista.agregarNodo(1);

		do {
			opt = Menu();
			switch (opt) {
				case 1:
					System.out.println("Imprimir lista");
					milista.listar();
					break;
				case 2:
					System.out.println("Invertir lista");
					milista.listarInverso();
					break;
				case 3:
					int valor, pos;
					System.out.println("Mover nodo de posición");
					System.out.println("Qué valor deseas mover?");
					valor = input.nextInt();
					System.out.println("A qué posición deseas mover?");
					pos = input.nextInt();
					milista.moverPosicion(valor, pos);
					break;
				case 4:
					int valorNodo;
					System.out.println("Modificar nodo");
					System.out.print("Ingresa el valor del nodo a modificar: ");
					valorNodo = input.nextInt();
					milista.modificarNodo(valorNodo);
					break;
				case 5:
					System.out.println("Hasta Luego");
					break;
			
				default:
					break;
			}

		} while (opt != 5);
	}
}

class NodoDoble{
	private NodoDoble sig;
	private NodoDoble ant;
	private int info;

	public NodoDoble(int info, NodoDoble sig, NodoDoble ant) {
		this.sig = sig;
		this.ant = ant;
		this.info = info;
	}
	public NodoDoble getSig() {
		return sig;
	}
	public void setSig(NodoDoble sig) {
		this.sig = sig;
	}
	public NodoDoble getAnt() {
		return ant;
	}
	public void setAnt(NodoDoble ant) {
		this.ant = ant;
	}
	public int getInfo() {
		return info;
	}
	public void setInfo(int info) {
		this.info = info;
	}
}


class ListaDoble{
	private static Scanner input = new Scanner(System.in);

	private NodoDoble primerNodo;
	private int numElem;
	
	
	public ListaDoble() {
		this.primerNodo = null;
		this.numElem = 0;
	}


	public void agregarNodo(int info) {
		NodoDoble nuevo = new NodoDoble(info, primerNodo, null);
		if(nuevo.getSig() != null) {
			nuevo.getSig().setAnt(nuevo);
			nuevo.setSig(nuevo.getSig());
		}
		primerNodo = nuevo;
		numElem++;
	}
	public void listar() {
		NodoDoble actual = primerNodo;
		while(actual.getSig() != null) {
			System.out.print(actual.getInfo() + " --> ");
			actual = actual.getSig();
		}
		System.out.println(actual.getInfo());
		System.out.println();
	}
	
	public void listarInverso() {
		NodoDoble actual = primerNodo;
		while(actual.getSig() != null) {
			actual = actual.getSig();
		}
		while(actual.getAnt() != null) {
			System.out.print(actual.getInfo() + " <-- ");
			actual = actual.getAnt();
		}
		System.out.print(actual.getInfo());
		System.out.println();
	}
	
	public void borrarNodo() {
		NodoDoble actual = primerNodo;
		System.out.println("Nodo borrado: "+actual.getInfo());
		actual.getSig().setAnt(null);
		primerNodo = actual.getSig();
	}

	public void modificarNodo(int valorNodo) {
		NodoDoble actual = primerNodo;
		//Nodo auxiliar que apunta al primer nodo, que nos ayudará a recorrer la lista
		while (actual != null) { //Se recorre del primer nodo al último
			if (actual.getInfo() == valorNodo) { // Si el valor ingresado existe en la lista
				System.out.print("Ingrese un nuevo valor para el nodo: ");
				int valor = input.nextInt();
				actual.setInfo(valor);
			} 
			actual = actual.getSig();
		}
	}

	public void moverPosicion(int valor, int posicion){
		NodoDoble actual = primerNodo, nodoAMover = null, nodoEnPosicion = null;
		int nodoAMoverPos = 0, nodoEnPosicionPos = 0;
		//Encontrar el nodo que se va a mover
		for (int i  = 0; i < numElem; i++){
			if (actual.getInfo() == valor){
				nodoAMover = actual;
				nodoAMoverPos = i;
				break;
			}
			else{
				actual = actual.getSig();
			}
		}
		//Encontrar el nodo que está en la posicion al que se va a mover.
		actual = primerNodo;
		for (int i = 0; i < numElem; i++){
			if (i == posicion - 1){
				nodoEnPosicion = actual;
				nodoEnPosicionPos = i;
				break;
			}
			else{
				actual = actual.getSig();
			}
		}
		//caso en que los nodos estan un tras otro
		if(nodoAMover.getSig() == nodoEnPosicion || nodoEnPosicion.getSig() == nodoAMover){
			int var = nodoAMover.getInfo();
			nodoAMover.setInfo(nodoEnPosicion.getInfo());
			nodoEnPosicion.setInfo(var);
		}
		//caso en que los nodos no estan uno tras otro
		//caso [1] mover el nodo hacia la derecha
		else{
			if (nodoAMoverPos == 0){
				primerNodo = nodoAMover.getSig();
				primerNodo.setAnt(null);	
			}
			//enlazar los nodos abyacentes del nodoAMover entre ellos
			if ((nodoAMoverPos != 0) && (nodoAMoverPos != (numElem - 1))){
				nodoAMover.getAnt().setSig(nodoAMover.getSig());
				nodoAMover.getSig().setAnt(nodoAMover.getAnt());
			}
			//enlazar el nodoAMover al nodoEnPosicion y al siguiente de ese
			if (nodoAMoverPos == (numElem - 1)){
				nodoAMover.getAnt().setSig(null);
				//if para el caso en que nodoAEnPosicion no es el primer nodo 
				if (nodoEnPosicion.getAnt() != null){
					nodoAMover.setAnt(nodoEnPosicion.getAnt());//
				}
				nodoAMover.setSig(nodoEnPosicion);
				//if para el caso en que nodoEnPosicion es el primer nodo
				if (nodoAMoverPos == (numElem - 1) && (nodoEnPosicionPos == 0)){
					nodoEnPosicion.setAnt(nodoAMover);
					primerNodo = nodoAMover;
					primerNodo.setAnt(null);
					return; 
				}
			}
			else if (nodoAMoverPos < nodoEnPosicionPos){
				nodoAMover.setAnt(nodoEnPosicion);//
				nodoAMover.setSig(nodoEnPosicion.getSig());//
			}
			else{
				nodoAMover.setAnt(nodoEnPosicion.getAnt());
				nodoAMover.setSig(nodoEnPosicion);
				if (nodoEnPosicionPos != 0){
					nodoEnPosicion.getAnt().setSig(nodoAMover);
				}
				nodoEnPosicion.setAnt(nodoAMover);
				primerNodo = nodoAMover;
				return;
			}
			if (nodoAMoverPos == (numElem - 1) && nodoEnPosicionPos == 0){
				primerNodo = nodoAMover;
				primerNodo.setAnt(null);
			}
			//enlazar el nodoEnPosicion y su siguiente al nodoAMover
			
			if (nodoAMoverPos == (numElem - 1)){
				nodoEnPosicion.getAnt().setSig(nodoAMover);
				nodoEnPosicion.setAnt(nodoAMover);
			}
			else{
				if (nodoEnPosicionPos != (numElem - 1)){
					nodoEnPosicion.getSig().setAnt(nodoAMover);//
				}
				nodoEnPosicion.setSig(nodoAMover);//
			}
			
		}
	}
	
	//Getters y Setters 
	public NodoDoble getPrimerNodo() {
		return primerNodo;
	}


	public void setPrimerNodo(NodoDoble primerNodo) {
		this.primerNodo = primerNodo;
	}


	public int getNumElem() {
		return numElem;
	}


	public void setNumElem(int numElem) {
		this.numElem = numElem;
	}	
}
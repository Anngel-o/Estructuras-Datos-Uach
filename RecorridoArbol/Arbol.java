// Fig. 17.17: Arbol.java
// Definicion de las clases NodoArbol y Arbol.

// definicion de la clase NodoArbol
class NodoArbol {
   // miembros de acceso del paquete
   NodoArbol nodoIzq; // nodo izquierdo
   int datos; // valor del nodo
   NodoArbol nodoDer; // nodo derecho

   // el constructor inicializa los datos y hace de este nodo un nodo raiz
   public NodoArbol(int datosNodo) {
      datos = datosNodo;
      nodoIzq = nodoDer = null; // el nodo no tiene hijos
   } // fin del constructor de NodoArbol

   // localiza el punto de insercion e inserta un nuevo nodo; ignora los valores
   // duplicados
   public void insertar(int valorInsertar) {
      // inserta en el subarbol izquierdo
      if (valorInsertar < datos) {
         // inserta nuevo NodoArbol
         if (nodoIzq == null)
            nodoIzq = new NodoArbol(valorInsertar);
         else // continua recorriendo el subarbol izquierdo
            nodoIzq.insertar(valorInsertar);
      } // fin de if
      else if (valorInsertar > datos) // inserta en el subarbol derecho
      {
         // inserta nuevo NodoArbol
         if (nodoDer == null)
            nodoDer = new NodoArbol(valorInsertar);
         else // continua recorriendo el subarbol derecho
            nodoDer.insertar(valorInsertar);
      } // fin de else if
   } // fin del metodo insertar
} // fin de la clase NodoArbol

// definicion de la clase Arbol
public class Arbol {
   private NodoArbol raiz;

   // el constructor inicializa un Arbol vacio de enteros
   public Arbol() {
      raiz = null;
   } // fin del constructor de Arbol sin argumentos

   // inserta un nuevo nodo en el arbol de busqueda binaria
   public void insertarNodo(int valorInsertar) {
      if (raiz == null)
         raiz = new NodoArbol(valorInsertar); // crea el nodo raiz aqu�
      else
         raiz.insertar(valorInsertar); // llama al metodo insertar
   } // fin del metodo insertarNodo

   // comienza el recorrido preorden
   public void recorridoPreorden() {
      ayudantePreorden(raiz);
   } // fin del metodo recorridoPreorden

   // metodo recursivo para realizar el recorrido preorden
   private void ayudantePreorden(NodoArbol nodo) {
      if (nodo == null)
         return;

      System.out.printf("%d ", nodo.datos); // imprime los datos del nodo
      ayudantePreorden(nodo.nodoIzq); // recorre el subarbol izquierdo
      ayudantePreorden(nodo.nodoDer); // recorre el subarbol derecho
   } // fin del m�todo ayudantePreorden

   // comienza recorrido inorden
   public void recorridoInorden() {
      ayudanteInorden(raiz);
   } // fin del metodo recorridoInorden

   // metodo recursivo para realizar el recorrido inorden
   private void ayudanteInorden(NodoArbol nodo) {
      if (nodo == null)
         return;

      ayudanteInorden(nodo.nodoIzq); // recorre el subarbol izquierdo
      System.out.printf("%d ", nodo.datos); // imprime los datos del nodo
      ayudanteInorden(nodo.nodoDer); // recorre el subarbol derecho
   } // fin del metodo ayudanteInorden

   // comienza recorrido postorden
   public void recorridoPostorden() {
      ayudantePostorden(raiz);
   } // fin del metodo recorridoPostorden

   // metodo recursivo para realizar el recorrido postorden
   private void ayudantePostorden(NodoArbol nodo) {
      if (nodo == null)
         return;

      ayudantePostorden(nodo.nodoIzq); // recorre el subarbol izquierdo
      ayudantePostorden(nodo.nodoDer); // recorre el subarbol derecho
      System.out.printf("%d ", nodo.datos); // imprime los datos del nodo
   } // fin del metodo ayudantePostorden
} // fin de la clase Arbol

/**************************************************************************
 * (C) Copyright 1992-2007 por Deitel & Associates, Inc. y *
 * Pearson Education, Inc. Todos los derechos reservados. *
 * *
 * RENUNCIA: Los autores y el editor de este libro han realizado su mejor *
 * esfuerzo para preparar este libro. Esto incluye el desarrollo, la *
 * investigacion y prueba de las teorias y programas para determinar su *
 * efectividad. Los autores y el editor no hacen ninguna garantia de *
 * ningun tipo, expresa o implicita, en relacion con estos programas o *
 * con la documentacion contenida en estos libros. Los autores y el *
 * editor no seran responsables en ningun caso por los daños consecuentes *
 * en conexion con, o que surjan de, el suministro, desempeño o uso de *
 * estos programas. *
 *************************************************************************/

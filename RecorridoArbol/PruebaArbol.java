// Fig. 17.18: PruebaArbol.java
// Este programa prueba la clase Arbol.
import java.util.Random;

public class PruebaArbol 
{
   public static void main( String args[] )
   {
      Arbol arbol = new Arbol();
      int valor;
      Random numeroAleatorio = new Random();

      System.out.println( "Insertando los siguientes valores: " );

      // inserta 10 enteros aleatorios de 0 a 99 en arbol
      for ( int i = 1; i <= 10; i++ ) 
      {
         valor = numeroAleatorio.nextInt( 100 );
         System.out.print( valor + " " );
         arbol.insertarNodo( valor );
      } // fin de for

      System.out.println ( "\n\nRecorrido preorden" );
      arbol.recorridoPreorden(); // realiza recorrido preorden de arbol

      System.out.println ( "\n\nRecorrido inorden" );
      arbol.recorridoInorden(); // realiza recorrido inorden de arbol

      System.out.println ( "\n\nRecorrido postorden" );
      arbol.recorridoPostorden(); // realiza recorrido postorden de arbol
      System.out.println();
   } // fin de main
} // fin de la clase PruebaArbol


/**************************************************************************
 * (C) Copyright 1992-2007 por Deitel & Associates, Inc. y                *
 * Pearson Education, Inc. Todos los derechos reservados.                 *
 *                                                                        *
 * RENUNCIA: Los autores y el editor de este libro han realizado su mejor *
 * esfuerzo para preparar este libro. Esto incluye el desarrollo, la      *
 * investigacion y prueba de las teorias y programas para determinar su   *
 * efectividad. Los autores y el editor no hacen ninguna garantia de      *
 * ningun tipo, expresa o implicita, en relacion con estos programas o    *
 * con la documentacion contenida en estos libros. Los autores y el       *
 * editor no seran responsables en ningun caso por los daños consecuentes *
 * en conexion con, o que surjan de, el suministro, desempeño o uso de    *
 * estos programas.                                                       *
 *************************************************************************/

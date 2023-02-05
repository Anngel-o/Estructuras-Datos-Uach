package ArregloAleatorio;
/*
 Guardar en un arreglo de 4x4 números aleatorios menores a 40, sumar los elementos de las filas y mostrar todo en pantalla.
 */
public class ArregloAleatorio {
    //By Ángel Ortiz Meraz
    public static void main(String[] args) {
        int array [][] = new int [4][4];

        for (int i = 0; i < array.length; i ++){
            for (int j = 0; j < array.length; j++) {
                array[i][j] = (int) (Math.random() * 40) + 1;
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(" " + array[i][j] + " ");
            }
            System.out.println();
        }
        
        //Sumar Filas
        for (int i = 0; i < array.length; i++) {
            int suma = 0;
            for (int j = 0; j < array.length; j++) {
                suma += array[i][j];   
            }
            System.out.println("Suma fila " + i + ": " + suma);
        }
    }
}

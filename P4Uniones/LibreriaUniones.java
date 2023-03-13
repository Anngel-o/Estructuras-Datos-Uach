package P4Uniones;

import java.util.Scanner;

class Date { //fecha
    int day;
    int month;
    int year;
}
class BookDate { //fecha de libro
    Date publication = new Date();
}
class BookData{ //datos de libro
    String nameEditorial;
    BookDate bookdate = new BookDate();
}
class Book { //atributos de libro
    String name;
    int numPages;
    String genre;
    BookData bookdata = new BookData();
}

public class LibreriaUniones {
    final static int nume = 2; //serán los registros a realizar
    
    public static void scanBook(Book[] book) {
        book = new Book[nume];
        Scanner input = new Scanner(System.in);
        System.out.println("**** REGISTRO DE LIBRO ****");
        System.out.println();

        for (int i = 0; i < book.length; i++) {
            book[i] = new Book();
            System.out.print("Ingresa el nombre del libro: ");
            book[i].name = input.nextLine();
            System.out.print("Ingresa el número de páginas: ");
            book[i].numPages = input.nextInt();
            input.nextLine();
            System.out.print("Ingresa el género del libro: ");
            book[i].genre = input.nextLine();

            System.out.println("Ingresa la fecha de publicación (dd/mm/aa): ");
            System.out.print("Ingresa el día: ");
            book[i].bookdata.bookdate.publication.day = input.nextInt();
            input.nextLine();
            System.out.print("Ingresa el mes: ");
            book[i].bookdata.bookdate.publication.month = input.nextInt();
            input.nextLine();
            System.out.print("Ingresa el año: ");
            book[i].bookdata.bookdate.publication.year = input.nextInt();
            input.nextLine();

            System.out.print("Ingresa el nombre de la editorial: ");
            book[i].bookdata.nameEditorial = input.nextLine();
            System.out.println();
        }

        System.out.println("**** LIBROS REGISTRADOS ****");
        for (int i = 0; i < book.length; i++) {
            System.out.println(book[i].name + ", " + book[i].numPages + ", " + book[i].genre + ", " + book[i].bookdata.bookdate.publication.day + "/" + book[i].bookdata.bookdate.publication.month + "/" + book[i].bookdata.bookdate.publication.year + ", " + book[i].bookdata.nameEditorial);
        }
    }

    public static void main(String[] args) {
        Book[] book = new Book[nume];
        Scanner inputOp = new Scanner(System.in);
        int op;

        System.out.println("Bienvenido al sistema de librería :D");
        System.out.print("Digite 1 para registrar un libro: ");
        op = inputOp.nextInt();
        if (op == 1) {
            scanBook(book);
        }
        else {
            System.out.println("Opción no disponible");
        }
    }
}
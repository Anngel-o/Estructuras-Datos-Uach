#include <iostream>
#define nume 2

using namespace std;

struct Date { //fecha
    int year;
    int month;
    int day;
};
union BookDate //fecha de libro
{
    struct Date publication;
};
struct BookData //datos de libro
{
    union BookDate bookdate;
    char editorial[25];
};
struct Book {
    char name[20];
    char numPages[20];
    char genre[20];
    struct BookData bookdata;
};

void scanBook(struct Book book[])
{
    //cout << "***** NUEVO REGISTRO *****" << endl;
    for (int i = 0; i < nume; i++)
    {
        cout << "Bienvenido :D" << endl;
        cout << "Ingresa el nombre del libro: ";
        cin.getline(book[i].name, 20, '\n');
        cout << "Ingresa el numero de paginas: ";
        cin.getline(book[i].numPages, 20, '\n');
        cout << "Ingresa el genero del libro: ";
        cin.getline(book[i].genre, 20, '\n');

        cout << "Ingresa la fecha de publicacion (dd/mm/aaaa): " << endl;
        cout << "Ingresa el dia: ";
        cin >> book[i].bookdata.bookdate.publication.day;
        cout << "Ingresa el mes: ";
        cin >> book[i].bookdata.bookdate.publication.month;
        cout << "Ingresa el anio: ";
        cin >> book[i].bookdata.bookdate.publication.year;

        cout << "Ingresa el nombre de la editorial: ";
        cin >> book[i].bookdata.editorial;
    }

    //system("cls");
}

void printBook(struct Book book)
{
    //cout << "***** REGISTRO EXITOSO! *****" << endl << endl;
    cout << "Operacion realizada con exito" << endl << endl;
    cout << "Nombre: " << book.name << endl;
    cout << "Paginas: " << book.numPages << endl;
    cout << "Genero: " << book.genre << endl;

    cout << "Publicacion: ";
    cout << book.bookdata.bookdate.publication.day << "/" << book.bookdata.bookdate.publication.month << "/" << book.bookdata.bookdate.publication.year << endl;

    cout << "Editorial: " << book.bookdata.editorial << endl;

    //system("pause");
    //system("cls");
    //cout << "***** HASTA LUEGO!  *****" << endl;
    cout << "Fin del registro que tenga un buen dia :)" << endl << endl;
}

int main(void) {
    int n;
    struct Book book[nume];

    scanBook(book);
    cout << "Numero de indice del libro para visualizar(el registro 1 es el indice 0): ";
    cin >> n;

    printBook(book[n]);

    return 0;
}
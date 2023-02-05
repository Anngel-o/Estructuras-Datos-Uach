#include <iostream>
#include <string.h>
//Encriptar una oración (cambiar las vocales a letras... u otras formas) por ejemplo: "uno es para" sería: 1n2 3s p4r4 -otra forma de encriptar-.

int main() {
    char phrase [] = "No puedo usar Java";
    char vowels [] = {"aeiou"};
    char encript [] = {"18634"};

    std::cout << "Encriptar una oracion" << std::endl;
    
    for (int i = 0; i < strlen(phrase); i++) {
        for (int j = 0; j < strlen(vowels); j++) {
            if (phrase[i] == vowels[j]) {
                phrase[i] = encript[j];
            }
        }
    }

    std::cout << "La palabra encriptada es: " << phrase << std::endl;
    
    return 0;
}
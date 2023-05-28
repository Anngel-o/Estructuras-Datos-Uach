#include<stdio.h>
#include<stdlib.h>
#include<stdio.h>


int main(){

    int c = 2; int r = 5;

    char* phrase = (char*) malloc(10*sizeof(char));
    //char* vowels = (char*) malloc(5*sizeof(char)); //unidimensional
    //char* encript = (char*) malloc(5*sizeof(char)); //unidimensional
    char* encript = (char*) malloc(5*2*sizeof(char)); //bidimensional
   
    *(encript + 0 + 0) = 'a';
    *(encript + 0 + 1) = '1';
   
    *(encript + 2 + 0) = 'e';
    *(encript + 2 + 1) = '8';
   
    *(encript + 4 + 0) = 'i';
    *(encript + 4 + 1) = '6';
   
    *(encript + 6 + 0) = 'o';
    *(encript + 6 + 1) = '3';
   
    *(encript + 8 + 0) = 'u';
    *(encript + 8 + 1) = '4';

   
    *phrase = 'm';
    *(phrase + 1) = 'u';
    *(phrase + 2) = 'r';
    *(phrase + 3) = 'c';
    *(phrase + 4) = 'i';
    *(phrase + 5) = 'e';
    *(phrase + 6) = 'l';
    *(phrase + 7) = 'a';
    *(phrase + 8) = 'g';
    *(phrase + 9) = 'o';

    //unidimensional
    /*
    *vowels = 'a';
    *(vowels + 1) = 'e';
    *(vowels + 2) = 'i';
    *(vowels + 3) = 'o';
    *(vowels + 4) = 'u';

    *encript = '1';
    *(encript + 1) = '8';
    *(encript + 2) = '6';
    *(encript + 3) = '3';
    *(encript + 4) = '4';

    for(int i = 0; i < 10; i++){
        for(int j = 0; j < 5; j++){
            if (*(phrase + i) == *(vowels + j){
                *(phrase + i) = *(encript + j);
            }
        }
    }

    */

   
    printf("The original word is: ");
    for(int i = 0; i < 10; i++){
        printf("%c", *(phrase + i));
    }
    printf("\n");

    for(int i = 0; i < 10; i++){
        for(int j = 0; j < 5; j++){
            if (*(phrase + i) == *(encript + (j*c))){
                *(phrase + i) = *(encript + (j*c) + 1);
            }
        }
    }
   
    printf("The encripted word is: ");
    for(int i = 0; i < 10; i++){
        printf("%c", *(phrase + i));
    }
    char* free(char* phrase);
    char* free(char* encript);
    //char* free(char* vowels);
    //char* free(char* encript);
}
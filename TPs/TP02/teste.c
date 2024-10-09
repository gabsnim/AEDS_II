#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main (int argc, char* argv[])
{
    char habilidades[] = "['Synchronize']";
    char *token;
    const char delimiters[] = ",[]";

    // Remover colchetes e aspas simples
    token = strtok(habilidades, delimiters);

    while (token != NULL) {
        printf("%s\n", token);  // Exibe cada habilidade separada
        token = strtok(NULL, delimiters);  // Continua com o próximo token
    }

    return 0;
}
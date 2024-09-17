/**
 * Gabriel Xavier Borges - 805347
 * Prova pratica 01 - linguagem C
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* cortarString(char* str)
{
    int n = strlen(str);
    char* newstr = malloc(n-2 * sizeof(char));
    int count = 0;
    for(int i = 0; i < n; i++)
    {
        if(str[i] >= 'a' && str[i] <= 'z' || str[i] >= 'A' && str[i] <= 'Z')
        {
            newstr[count] = str[i];
            count++;
        }
    }
    newstr[count] = '\0';
    return newstr;
}

int main(int argc, char *argv[])
{
    int n = 0;
    scanf("%d", &n);
    while (n < 0 || n > 100)
    {
        scanf("%d", &n);
    }

    int countMais = 0;   // contar simbolos +
    char tokens[n];      // array de simbolos + e -
    char crianca[n][21]; // array de string [n] = tamanho da entrada e [20] tamanho da string + 1 para /0
    char aux[20];        // auxiliar para fazer swap
    char entrada[23]; // ler entrada do teclado
    char* stringaux;
    
    /**
     * Ler da entrada padrao e copiar para arrays
     */
    for (int i = 0; i < n; i++)
    {
        scanf(" %[^\n]", entrada);
        tokens[i] = entrada[0];
        stringaux = cortarString(entrada);
        //printf("aux = %s", stringaux);
        strcpy(crianca[i], stringaux);
    }

    /*
        Ordenar array de strings
    */
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n - i - 1; j++)
        {
            if (strcmp(crianca[j], crianca[j+1]) > 0) //palavras diferentes, faz swap;
            {
                strcpy(aux, crianca[j]);
                strcpy(crianca[j], crianca[j + 1]);
                strcpy(crianca[j + 1], aux);
            }
        }
    }

    //mostrar criancas
    for (int i = 0; i < n; i++)
    {
        printf("%s\n", crianca[i]);
    }

    for (int i = 0; i < n; i++) //contar tokens == '+'
    {
        if (tokens[i] == '+')
        {
            countMais++;
        }
    }

    printf("Se comportaram: %d | Nao se comportaram: %d", countMais, (n - countMais)); //subtrair count mais do total de entradas

    return 0;
}
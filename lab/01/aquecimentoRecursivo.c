/**
 * Gabriel Xavier Borges - 805347 - 15/08
 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
#include <stdbool.h>

/**
 * Funcao para verificar se e maiuscula
 * @param caracter
 * @return bool
 */
bool isUpper (char c)
{
    bool r = false;
    if(c >= 'A' && c <= 'Z')
    {
        r = true;
    }
    return r;
}

/**
 * Funcao recursiva para contar letras maiusculas numa string
 * @param string, index
 * @return int
 */
int countUpper (char* str, int index)
{
    int count = 0;
    if(index < strlen(str))
    {
        if(isUpper(str[index]))
        {
            count++;
        }
        count += countUpper(str, index + 1);
    }
    return count;
}

/**
 * Funcao auxiliar para chamar a funcao countUpper
 * @param string
 * @return string, index
 */
int countUpperAux (char* str)
{
    return countUpper(str, 0);
}

/**
 * Funcao principal
 */
int main (int agrc, char* agrv[])
{
    char* str = (char*)calloc(80, sizeof(char));

    fgets(str,80,stdin);

    do
    {
        printf("%d\n", countUpperAux(str));
        fgets(str,80,stdin);
    } while (strcmp(str, "FIM\n")!= 0);
    
    free(str);

    return 0;
}
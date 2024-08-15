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
 * Funcao para contar maiusculas
 * @param string
 * @return int
 */
int countUpper (char* str)
{
    int count = 0;
    for(int i = 0; i < strlen(str); i++)
    {
        if(isUpper(str[i]))
        {
            count = count + 1;
        }
    }
    return count;
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
        printf("%d\n", countUpper(str));
        fgets(str,80,stdin);
    }while(strcmp(str, "FIM\n") != 0);

    free(str);

    return 0;
}
/**
 * Gabriel Xavier Borges - 805347 - Q11
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

/**
 * Funcao para ler linha
 * @return linha 
 */
char *readLine()
{
    char *str = (char *)calloc(1000, sizeof(char));

    if (str != NULL)
    {
        fgets(str, 1000, stdin);
        int i = strlen(str);
        if (i > 0 && str[i - 1] == '\n')
        {
            str[i - 1] = '\0';
        }
    }
    return str;
}

/**
 * Funcao para verificar se string e um palindromo
 * @param string, index i, index j
 * @return bool
 */
bool isPalindromo(char* str, int i, int j)
{
    if(i < strlen(str) / 2)
    {
        if(str[i] != str[j])
        {
            return false;
        }
        else
        {
            return isPalindromo(str, i + 1, j - 1);
        }
    }
    return true;
}

/**
 * Funcao auxiliar para dar valor inicial a funcao isPalindromo()
 * @param string
 * @return string, index(i), index(j)
 */
bool isPalindromoAux(char* str)
{
    return isPalindromo(str, 0, strlen(str) - 1);
}

/**
 * Funcao principal
 */
int main(int agrc, char *agrv[])
{
    char *str = NULL;
    str = readLine();
    do
    {  
        if(isPalindromoAux(str))
        {
            printf("SIM\n");
        }
        else
        {
            printf("NAO\n");
        }
        str = readLine();
    } while (strcmp(str, "FIM\0") != 0);
    
    return 0;
}
/**
 * Gabriel Xavier Borges - 805347 - 2
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

/**
 * Funcao para verificar se e palindromo
 * @param string
 * @return bool
 */
bool isPalindromo(char *str)
{
    bool r = true;
    int j = strlen(str) - 1;
    for (int i = 0; i < strlen(str) / 2; i++)
    {
        if (str[i] != str[j])
        {
            r = false;
            i = strlen(str) / 2;
        }
        j--;
    }
    return r;
}//Existem erros de charset

/**
 * Funcao para ler linha
 * @return linha
 */
char *readline()
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
 * Funcao principal
 */
int main(int agrc, char *agrv[])
{
    char *str = NULL;
    str = readline();
    do
    {
        if (isPalindromo(str) == true)
        {
            printf("SIM\n");
        }
        else
        {
            printf("NAO\n");
        }
        str = readline();
    } while (strcmp(str, "FIM\0") != 0);

    return 0;
}
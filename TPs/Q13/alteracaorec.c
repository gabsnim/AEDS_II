/**
 * Gabriel Xavier Borges - 805347 - Q13
 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>

char* alteracao (char* str, char* nova, int i, char c, char z)
{
    if(i < strlen(str))
    {   
        //printf("%c %c\n", c, z);

        if(str[i] != c)
        {
            nova[i] = str[i];
        }
        else
        {
            nova[i] = z;
        }
        alteracao(str, nova, i + 1,c ,z);
    }
    return nova;
}

char* alteracaoaux (char* str)
{
    char* nova = (char*)calloc(strlen(str) + 1, sizeof(char));
    char c = (char)('a' + rand() % 26);
    char z = (char)('a' + rand() % 26);
    return alteracao(str, nova, 0, c, z);
}

char* readLine()
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

int main (int argc, char* argv[])
{
    srand(12344321);

    char *str = NULL;
    char *nova = NULL;
    str = readLine();
    do
    {
        nova = alteracaoaux(str);
        printf("%s\n", nova);
        str = readLine();
    } while (strcmp(str, "FIM\0") != 0);
    return 0;
}


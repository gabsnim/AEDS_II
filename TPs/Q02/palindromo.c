#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <locale.h>

bool isEnd (char str[])
{
    bool r = false;
    if(strcmp(str, "FIM") == 0)
    {
        r = true;
    }
    return r;
}

bool isPalindromo (char* str)
{
    bool r = true;
    int j = strlen(str) - 1;
    printf("%d", j);
    for(int i = 0; i < strlen(str); i++)
    {
        printf("%c + %c", str[i], str[j]);
        if(str[i] != str[j])
        {
            r = false;
        }
        j--;
    }
    return r;
}

char* readLine ()
{

}

int main (int agrc, char* argv[])
{
    setlocale(LC_CTYPE, "UTF-8");
}
#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <locale.h>

bool isPalindromo (char string [])
{
    int x = strlen(string) - 1;
    bool r = true;
    char c = ' ';

    for(int i = 0; i < strlen(string); i++)
    {
        c = string[i];
        if(c != string[x])
        {
            r = false;
        }
        x--;
    }
    return r;
}
int main (int argc, char const *argv[])
{
    setlocale(LC_CTYPE, "UTF-8");
    char string [80];
    scanf("%s", string);
    if(isPalindromo(string))
    {
        printf("SIM\n");
    }
    else
    {
        printf("NAO\n");
    }
}
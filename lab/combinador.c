#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int agrc, char* agrv[])
{

    char *string1 = calloc(80, sizeof(char));
    char *string2 = calloc(80, sizeof(char));
    int x = 0, y = 0;
    scanf("%s", string1);
    scanf("%s", string2);


    if (strlen(string1) > strlen(string2))
    {
        for (int i = 0; i < strlen(string1); i++)
        {
            printf("%c", string1[i]);
            if (strlen(string2) > x)
            {
                printf("%c", string2[i]);
                x = x + 1;
            }
        }
    }
    else if (strlen(string1) < strlen(string2))
    {
        for (int i = 0; i < strlen(string2); i++)
        {
            if (strlen(string1) > y)
            {
                printf("%c", string1[i]);
                y = y + 1;
            }
            printf("%c", string2[i]);
        }
    }
    else
    {
        for(int i = 0; i < strlen(string1); i++)
        {
            printf("%c%c", string1[i], string2[i]);
        }
    }

    return 0;
}
/**
 * Gabriel Xavier Borges - 805347 - Lab02
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void print(char *string1, char *string2)
{
    int x = 0, y = 0;
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
        for (int i = 0; i < strlen(string1); i++)
        {
            printf("%c%c", string1[i], string2[i]);
        }
    }
    printf("\n");
}

int main(void)
{
    char *string1 = (char *)calloc(80, sizeof(char));
    char *string2 = (char *)calloc(80, sizeof(char));

    while (scanf("%s", string1) != EOF)
    {
        scanf("%s", string2);

        print(string1, string2);
    }

    return (0);
}
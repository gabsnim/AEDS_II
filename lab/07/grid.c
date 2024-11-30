/**
 * Gabriel Xavier Borges - 805347
 * Lab 07
*/

#include <stdio.h>
#include <stdlib.h>

int position(int cmp, int* gridfinish, int n)
{
    int x = 0;
    for (int i = 0; i < n; i++)
    {
        if (gridfinish[i] == cmp)
        {
            x = i;
            i = n;
        }
    }
    return x;
}

int countMoves(int* gridstart, int* gridfinish, int n)
{
    int moves = 0;
    int x = 0;
    int y = 0;
    
    for (int i = 0; i < n - 1; i++)
    {
        x = position(gridstart[i], gridfinish, n); 

        for (int j = i + 1; j < n; j++)
        {
            y = position(gridstart[j], gridfinish, n); 
            if (y < x)
            {
                moves++;
            }
        }
    }
    return moves;
}

int main (int argc, char** argv)
{

    int n = 0;
    while (scanf("%d", &n) != EOF)
    {
        // scanf("%d", &n);
        int x = 0;
        int count = 0;

        int *gridstart = malloc(n * sizeof(int));
        int *gridfinish = malloc(n * sizeof(int));

        if(gridstart == NULL)printf("ERRO ao alocar memoria\n");
        if(gridfinish == NULL)printf("ERRO ao alocar memoria\n");

        for(int i = 0; i < n; i++)
        {
            scanf("%d", &x);
            gridstart[i] = x;
        }

        for(int i = 0; i < n; i++)
        {
            scanf("%d", &x);
            gridfinish[i] = x;
        }

        printf("%d\n", countMoves(gridstart, gridfinish, n));  
    }  

    //1 2 3 4 5
    //3 1 2 5 4
    //2 + 1 = 3;
}
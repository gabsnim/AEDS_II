#include <stdio.h>
#include <stdlib.h>

int main (int argc, char** argv)
{
    int n = 0;
    scanf("%d", &n);
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

    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < n; j++)
        {
            if(gridstart[i] != gridfinish[i])
            {
                for(int k = 0; gridstart[k] != gridfinish[k]; k++)
                {
                    count += n - k;
                }    
            }
        }
    }
    printf("%d", count);    
    //1 2 3 4 5
    //3 1 2 5 4
    //2 + 1 = 3;
}